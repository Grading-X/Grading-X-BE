package com.pytorch.gradingx.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "게스트 시험 결과 조회 요청")
public class ResultGuestRequest {
    @NotNull(message = "이메일은 필수 필드입니다.")
    @Email(message = "올바른 이메일 값을 넣어 주세요.")
    @Schema(description = "게스트 이메일", example = "chaejm55@gmail.com")
    private String email;
}
