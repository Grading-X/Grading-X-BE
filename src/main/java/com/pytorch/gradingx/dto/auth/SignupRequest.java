package com.pytorch.gradingx.dto.auth;

import com.pytorch.gradingx.domain.enumeration.MemberType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Schema(description = "회원가입 요청")
public class SignupRequest {
    @Email
    @Schema(description = "이메일", example = "user@example.com")
    public String email;

    @NotBlank
    @Schema(description = "비밀번호", example = "password1234")
    public String password;

    @NotBlank
    @Schema(description = "이름", example = "홍길동")
    public String name;

    @NotBlank
    @Schema(description = "멤버 타입", example = "INSTRUCTOR")
    public MemberType memberType;
}
