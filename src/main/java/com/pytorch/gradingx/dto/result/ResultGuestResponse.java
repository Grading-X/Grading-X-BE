package com.pytorch.gradingx.dto.result;

import com.pytorch.gradingx.dto.grading.GradingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class ResultGuestResponse {
    private Long resultId;
    private List<GradingResponse> gradingResponseList;
}
