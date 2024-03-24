package com.pytorch.gradingx.dto.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Schema(description = "문제 게스트 답변 응답")
public class QuestionGuestAnswerResponse {
    @Schema(description = "게스트 답변", example = "글쎄요")
    public String answer;
    @Schema(description = "게스트 점수", example = "0")
    public String score;
}
