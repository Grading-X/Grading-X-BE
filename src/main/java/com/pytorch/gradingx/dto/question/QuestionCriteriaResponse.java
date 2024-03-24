package com.pytorch.gradingx.dto.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
@Schema(description = "문제 채점 기준 응답")
public class QuestionCriteriaResponse {
    @Schema(description = "모범답안 리스트", example = "[\"2\"]")
    public List<String> answers;
    @Schema(description = "키워드 리스트", example = "[\"덧셈\"]")
    public List<String> keywords;
}
