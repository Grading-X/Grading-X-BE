package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.authentication.jwt.JwtTokenValidator;
import com.pytorch.gradingx.dto.auth.LoginRequest;
import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.dto.auth.TokenResponse;
import com.pytorch.gradingx.exception.AuthenticationException;
import com.pytorch.gradingx.authentication.jwt.JwtTokenGenerator;
import com.pytorch.gradingx.authentication.jwt.Token;
import com.pytorch.gradingx.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "인증 관련 API")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final JwtTokenValidator jwtTokenValidator;

    @Operation(summary = "로그인", description = "email, password를 이용하여 요청 새로 생성된 액세스 토큰과 리프레시 토큰을 반환")
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Validated LoginRequest request) {
        if(!memberService.checkMember(request.email, request.password)) {
            throw new AuthenticationException("사용자 정보가 일치하지 않습니다.");
        }
        Token token = jwtTokenGenerator.createToken(request.email);
        memberService.saveRefreshToken(request.email, token.getRefreshToken());
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @Operation(summary = "로그아웃", description = "http 요청의 헤더에서 액세스 토큰을 추출하고 유효성 체크 후, 리프레시 토큰 DB에서 삭제")
    @GetMapping("/logout")
    public ResponseEntity logout(@CookieValue("access_token") String accessToken) {
        String email = jwtTokenValidator.extractEmail(accessToken, jwtTokenGenerator.createSecretKey());
        memberService.deleteRefreshToken(email);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "액세스 토큰 재발급", description = "http 요청의 헤더에서 리프레시 토큰을 추출하고 유효성, 존재유무 체크 후, 확인되면 액세스 토큰 리턴.")
    @GetMapping("/reissue")
    public ResponseEntity<String> reissueAccessToken(@CookieValue("refresh_token") String refreshToken) {
        return ResponseEntity.ok(jwtTokenGenerator.reissueAccessToken(refreshToken));
    }

    @Operation(summary = "회원가입", description = "email, password, 이름, 멤버 타입을 요청받고, 새로 생성된 액세스 토큰과 리프레시 토큰을 반환")
    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody @Validated SignupRequest request) {
        memberService.signup(request);
        Token token = jwtTokenGenerator.createToken(request.email);
        memberService.saveRefreshToken(request.email, token.getRefreshToken());
        return ResponseEntity.status(HttpStatus.CREATED).body(new TokenResponse(token));
    }
}
