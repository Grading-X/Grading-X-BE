package com.pytorch.gradingx.authentication.interceptor;

import com.pytorch.gradingx.authentication.jwt.JwtTokenGenerator;
import com.pytorch.gradingx.authentication.jwt.JwtTokenValidator;
import com.pytorch.gradingx.authentication.jwt.TokenType;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class TokenCheckInterceptor implements HandlerInterceptor {
    private final JwtTokenGenerator jwtTokenGenerator;
    private final JwtTokenValidator jwtTokenValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        int check = 0;

        if(cookies == null) {
            throw new JwtException("Jwt토큰이 존재하지 않습니다.");
        }

        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("access_token") || cookie.getName().equals("refresh_token")) {
                try {
                    TokenType tokenType = cookie.getName().equals("access_token") ? TokenType.ACCESS : TokenType.REFRESH;
                    validateToken(cookie.getValue(), tokenType);
                    check++;
                } catch (JwtException e) {
                    throw new JwtException(e.getMessage());
                }
            }
        }
        if(check > 0) return true;

        throw new JwtException("Jwt토큰이 존재하지 않습니다.");
    }

    private void validateToken(String token, TokenType type) throws JwtException {
        Key secretKey = jwtTokenGenerator.createSecretKey();
        jwtTokenValidator.validateTokenExpiration(token, secretKey);
        jwtTokenValidator.validateTokenType(token, secretKey, type);
    }
}
