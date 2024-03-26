package com.pytorch.gradingx.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenValidator {

    public String extractEmail(String token, Key secretKey) {
        return extractClaims(token, secretKey).getSubject();
    }

    protected void validateToken(String token, Key secretKey, TokenType type) {
        Claims claims = extractClaims(token, secretKey);
        Date expiration = claims.getExpiration();
        if (expiration.before(new Date())) {
            throw new JwtException("Token이 만료되었음");
        }
        if(!claims.get("type").equals(type)) {
            throw new JwtException("올바르지 않은 토큰 타입");
        }
    }

    private Claims extractClaims(String token, Key secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
