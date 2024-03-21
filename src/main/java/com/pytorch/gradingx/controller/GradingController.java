package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.grading.GradingRequest;
import com.pytorch.gradingx.dto.grading.GradingResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Tag(name = "Grading", description = "문제 제출 관련 API")
@RestController
@RequestMapping("/api/grading")
public class GradingController {
    @PostMapping
    public ResponseEntity<GradingResponse> doGrade(@RequestBody GradingRequest gradingRequest) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", "test.py", gradingRequest.getAnswerId().toString(), gradingRequest.getAnswer(),
                gradingRequest.getQuestionId().toString(), gradingRequest.getEmail());
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));

        String result = reader.readLine();
        GradingResponse testGradingResponse = GradingResponse.builder()
                .answerId(gradingRequest.getAnswerId())
                .answer(gradingRequest.getAnswer())
                .score(Long.parseLong(result))
                .build();

        return ResponseEntity.ok().body(testGradingResponse);
    }
}
