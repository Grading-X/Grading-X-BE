package com.pytorch.gradingx.dto.objection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Schema(description = "이의 답변 요청")
public class ObjectionReplyRequest {
    @Schema(description = "답변 제목", example = "니가 틀렸어")
    public String title;
    @Schema(description = "답변 내용", example = "이렇게 풀어야 하는데...")
    public String content;
}
