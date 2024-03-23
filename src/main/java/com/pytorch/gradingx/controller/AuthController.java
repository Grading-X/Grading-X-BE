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

    @Operation(summary = "로그인", description = "email, password를 이용하여 로그인합니다.")
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(new TokenResponse());
    }

    @Operation(summary = "액세스 토큰 재발급", description = "JWT 토큰을 둘다 입력하여 액세스 토큰을 재발급합니다.")
    @PostMapping("/reissue")
    public ResponseEntity<String> reissueAccessToken(@RequestBody TokenRequest token) {
        return ResponseEntity.ok("");
    }

    @Operation(summary = "회원가입", description = "email, password를 이용하여 회원가입합니다.")
    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody SignupRequest request) {
        var token = new TokenResponse();
        token.accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6dHJ1ZSwiaWF0IjoxNzEwMTYzNzU2LCJleHAiOjE3MTAxNjU1NTZ9.nm2x6Cspg_9jc2HiOxq05XQhyKtgM1KDfpCh5iNqt5M";
        token.refreshToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6ZmFsc2UsImlhdCI6MTcxMDE2Mzc1NiwiZXhwIjoxNzEyNzU1NzU2fQ.1L0-OLcq-cr1zTg2Ij51AOf7OsDrwMeS_FRs0Iut9BI";
        return ResponseEntity.ok(token);
    }
}
