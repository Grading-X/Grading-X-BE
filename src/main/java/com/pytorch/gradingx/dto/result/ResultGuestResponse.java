package com.pytorch.gradingx.dto.result;

import com.pytorch.gradingx.dto.grading.GradingResponse;
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
@Schema(description = "게스트 시험 결과 조회 응답")
public class ResultGuestResponse {
    @Schema(description = "결과 ID", example = "1")
    private Long resultId;
    @Schema(description = "채점 결과 리스트", implementation = GradingResponse.class)
    private List<GradingResponse> gradingResponseList;
}
