package com.pytorch.gradingx.dto.result;

import com.pytorch.gradingx.dto.grading.GradingResponse;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
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
public class ResultInstructorResponse {
    private Long resultId;
    private List<GradingResponse> gradingResponseList;
    private MemberInfoResponse memberInfoResponse;
    private Double average;
    private Double sd;
    private Long rank;
}
