package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.auth.LoginRequest;
import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.dto.auth.TokenRequest;
import com.pytorch.gradingx.dto.auth.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(new TokenResponse());
    }

    @PostMapping("/reissue")
    public ResponseEntity<String> reissueAccessToken(@RequestBody TokenRequest token){
        return ResponseEntity.ok("");
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(new TokenResponse());
    }
}
