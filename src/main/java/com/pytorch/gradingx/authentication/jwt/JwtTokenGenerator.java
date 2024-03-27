package com.pytorch.gradingx.authentication.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class JwtTokenGenerator {
    @Value("${jwt.secret}")
    private String secret;

    private final JwtTokenValidator jwtTokenValidator;

    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24;  // 1일
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 14;  // 2주

    public Token createToken(String email) {
        long current = System.currentTimeMillis();
        Date accessExpireTime = new Date(current + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshExpireTime = new Date(current + REFRESH_TOKEN_EXPIRE_TIME);
        String accessToken = generateToken(email, accessExpireTime, Map.of("type", TokenType.ACCESS));
        String refreshToken = generateToken(email, refreshExpireTime, Map.of("type", TokenType.REFRESH));
        return Token.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public String reissueAccessToken(String refreshToken) {
        jwtTokenValidator.validateTokenType(refreshToken, createSecretKey(), TokenType.REFRESH);
        String email = jwtTokenValidator.extractEmail(refreshToken, createSecretKey());
        Date expireTime = new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME);
        return generateToken(email, expireTime, Map.of("type", TokenType.ACCESS));
    }

    private String generateToken(String email, Date expireTime, Map<String, Object> claims) {
        Key secretKey = createSecretKey();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setExpiration(expireTime)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public Key createSecretKey() {
        byte[] keyBytes = secret.getBytes();
        if (keyBytes.length < 32) {
            try {
                keyBytes = Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(keyBytes), 32);
            } catch (NoSuchAlgorithmException e) {
                throw new JwtException("JWT secret key 생성 실패");
            }
        }
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
