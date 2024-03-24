package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.result.ResultGuestRequest;
import com.pytorch.gradingx.dto.result.ResultGuestResponse;
import com.pytorch.gradingx.dto.result.ResultInstructorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Result", description = "시험 결과 관련 API")
@RestController
@RequestMapping("/api/result")
public class ResultController {

    @Operation(summary = "시험 결과 조회", description = "시험 결과를 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "교수자용 시험 결과 조회 성공(게스트는 결과 id와 채점 결과 리스트만 반환)",
                content = @Content(schema = @Schema(implementation = ResultInstructorResponse.class))),
        @ApiResponse(responseCode = "200", description = "게스트용 시험 결과 조회 성공",
                content = @Content(schema = @Schema(implementation = ResultGuestResponse.class))),
    })
    @GetMapping
    public ResponseEntity<?> getResult(@RequestHeader(value = "Authorization", required = false) String token,
                                                        @Valid @RequestBody(required = false) ResultGuestRequest resultGuestRequest) {
        // 일단 지금은 인가 처리 하는 척만 하는 걸로...(토큰이 있으면 교수자, 없으면 게스트)
        if (token != null) {
            return ResponseEntity.ok().body(new ResultInstructorResponse());
        }
        else {
            if (resultGuestRequest != null) {
                return ResponseEntity.ok().body(new ResultGuestResponse());
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
    }
}
