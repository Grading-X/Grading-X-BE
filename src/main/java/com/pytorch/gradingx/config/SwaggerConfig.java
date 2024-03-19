package com.pytorch.gradingx.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        var info = new Info()
                .title("GradingX API")
                .version("0.0.1")
                .description("서술형 자동 채점 서비스 GradingX API 문서입니다.");
        var bearerKeySecurityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("JWT 인증 토큰을 입력해주세요.");
        var components = new Components().addSecuritySchemes("bearer-key", bearerKeySecurityScheme);
        var securityItem = new SecurityRequirement().addList("bearer-key");

        return new OpenAPI()
                .info(info)
                .components(components)
                .addSecurityItem(securityItem);
    }

}
