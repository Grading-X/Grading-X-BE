package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.auth.LoginRequest;
import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.dto.auth.TokenRequest;
import com.pytorch.gradingx.dto.auth.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "인증 관련 API")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Operation(summary = "로그인", description = "email, password를 이용하여 요청 새로 생성된 액세스 토큰과 리프레시 토큰을 반환")
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(new TokenResponse());
    }

    @Operation(summary = "로그아웃", description = "http 요청의 헤더에서 액세스 토큰을 추출하고 유효성 체크 후, 리프레시 토큰 DB에서 삭제")
    @PostMapping("/logout")
    public ResponseEntity login() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "액세스 토큰 재발급", description = "http 요청의 헤더에서 리프레시 토큰을 추출하고 유효성, 존재유무 체크 후, 확인되면 액세스 토큰 리턴.")
    @PostMapping("/reissue")
    public ResponseEntity<String> reissueAccessToken() { //요청 부분 헤더에서 리프레시 토큰 받아오도록 할 예정
        return ResponseEntity.ok("");
    }

    @Operation(summary = "회원가입", description = "email, password, 이름, 멤버 타입을 요청받고, 새로 생성된 액세스 토큰과 리프레시 토큰을 반환")
    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody SignupRequest request) {
        var token = new TokenResponse();
        token.accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6dHJ1ZSwiaWF0IjoxNzEwMTYzNzU2LCJleHAiOjE3MTAxNjU1NTZ9.nm2x6Cspg_9jc2HiOxq05XQhyKtgM1KDfpCh5iNqt5M";
        token.refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6ZmFsc2UsImlhdCI6MTcxMDE2Mzc1NiwiZXhwIjoxNzEyNzU1NzU2fQ.1L0-OLcq-cr1zTg2Ij51AOf7OsDrwMeS_FRs0Iut9BI";
        return ResponseEntity.ok(token);
    }
}
