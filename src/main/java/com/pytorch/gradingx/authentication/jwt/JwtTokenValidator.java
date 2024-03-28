package com.pytorch.gradingx.authentication.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenValidator {

    public String extractEmail(String token, Key secretKey) {
        return extractClaims(token, secretKey).getSubject();
    }

    public void validateTokenExpiration(String token, Key secretKey) {
        Claims claims = extractClaims(token, secretKey);
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date())) {
            throw new JwtException("Token이 만료되었음");
        }
    }

    public void validateTokenType(String token, Key secretKey, TokenType type) {
        Claims claims = extractClaims(token, secretKey);
        if(!claims.get("type").equals(type.name())) {
            throw new JwtException("올바르지 않은 토큰 타입");
        }
    }

    private Claims extractClaims(String token, Key secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
