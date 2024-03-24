package com.pytorch.gradingx.dto.result;

import com.pytorch.gradingx.dto.grading.GradingResponse;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "교수자 시험 결과 조회 응답")
public class ResultInstructorResponse {
    @Schema(description = "결과 ID", example = "1")
    private Long resultId;

    @Schema(description = "채점 결과 리스트")
    @ArraySchema(schema = @Schema(implementation = GradingResponse.class))
    private List<GradingResponse> gradingResponseList;

    @Schema(description = "강의 ID", example = "1")
    private MemberInfoResponse memberInfoResponse;

    @Schema(description = "평균 점수", example = "90.0")
    private Double average;

    @Schema(description = "표준편차", example = "10.0")
    private Double sd;

    @Schema(description = "순위", example = "1")
    private Long rank;
}
