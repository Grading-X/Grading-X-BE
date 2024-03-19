package com.pytorch.gradingx.dto.grading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class GradingRequest {
    private Long answerId;
    private String answer;
    private Long questionId;
    private String email;
}
