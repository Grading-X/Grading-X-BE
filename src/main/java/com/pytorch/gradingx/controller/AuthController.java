package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.auth.TokenRequest;
import com.pytorch.gradingx.dto.auth.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestParam String id, @RequestParam String pw){
        return ResponseEntity.ok(new TokenResponse());
    }

    @GetMapping("/reissue")
    public ResponseEntity<String> reissueAccessToken(@RequestBody TokenRequest token){
        return ResponseEntity.ok("");
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@RequestBody TokenRequest token){
        return ResponseEntity.ok(new TokenResponse());
    }
}
