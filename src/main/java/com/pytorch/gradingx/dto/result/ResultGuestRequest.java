package com.pytorch.gradingx.dto.result;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ResultGuestRequest {
    @NotNull(message = "이메일은 필수 필드입니다.")
    @Email(message = "올바른 이메일 값을 넣어 주세요.")
    private String email;
}
