package com.pytorch.gradingx.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ExamSaveRequest {
    private String answer;
    private Long questionId;
    private String email;
}
