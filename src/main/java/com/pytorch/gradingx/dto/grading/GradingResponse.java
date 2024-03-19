package com.pytorch.gradingx.dto.grading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class GradingResponse {
    private Long answerId;
    private Long score;
}
