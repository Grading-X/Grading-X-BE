package com.pytorch.gradingx.dto.auth;

import com.pytorch.gradingx.domain.enumeration.MemberType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Schema(description = "회원가입 요청")
public class SignupRequest {
    @Schema(description = "이메일", example = "user@example.com")
    public String email;
    @Schema(description = "비밀번호", example = "password1234")
    public String password;
    @Schema(description = "이름", example = "홍길동")
    public String name;
    @Schema(description = "멤버 타입", example = "INSTRUCTOR")
    public MemberType memberType;
}
