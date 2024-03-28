package com.pytorch.gradingx.annotation;

import com.pytorch.gradingx.authentication.jwt.JwtTokenGenerator;
import com.pytorch.gradingx.authentication.jwt.JwtTokenValidator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.util.WebUtils;

@Component
@RequiredArgsConstructor
public class TokenEmailResolver implements HandlerMethodArgumentResolver {
    private final JwtTokenGenerator jwtTokenGenerator;
    private final JwtTokenValidator jwtTokenValidator;
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TokenEmail.class)
                && parameter.getParameterType().equals(String.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Cookie cookie = WebUtils.getCookie(webRequest.getNativeRequest(HttpServletRequest.class), "access_token");
        String accessToken = cookie != null ? cookie.getValue() : null;
        return jwtTokenValidator.extractEmail(accessToken, jwtTokenGenerator.createSecretKey());
    }
}
