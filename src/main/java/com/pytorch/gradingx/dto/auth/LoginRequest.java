package com.pytorch.gradingx.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Schema(description = "로그인 요청")
public class LoginRequest {
    @Schema(description = "이메일", example = "user@example.com")
    public String email;
    @Schema(description = "비밀번호", example = "password1234")
    public String password;
}
