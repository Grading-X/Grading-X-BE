package com.pytorch.gradingx.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Schema(description = "로그인 요청")
public class LoginRequest {
    @Email
    @Schema(description = "이메일", example = "user@example.com")
    public String email;

    @NotBlank
    @Schema(description = "비밀번호", example = "password1234")
    public String password;
}
