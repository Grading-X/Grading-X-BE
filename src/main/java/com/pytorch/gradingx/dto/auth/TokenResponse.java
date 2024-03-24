package com.pytorch.gradingx.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "토큰 응답")
public class TokenResponse {
    @Schema(description = "액세스 토큰", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6dHJ1ZSwiaWF0IjoxNzEwMTYzNzU2LCJleHAiOjE3MTAxNjU1NTZ9.nm2x6Cspg_9jc2HiOxq05XQhyKtgM1KDfpCh5iNqt5M")
    public String accessToken;
    @Schema(description = "리프레시 토큰", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidHlwZSI6IlVTRVIiLCJpc0FjY2VzcyI6ZmFsc2UsImlhdCI6MTcxMDE2Mzc1NiwiZXhwIjoxNzEyNzU1NzU2fQ.1L0-OLcq-cr1zTg2Ij51AOf7OsDrwMeS_FRs0Iut9BI")
    public String refreshToken;
}
