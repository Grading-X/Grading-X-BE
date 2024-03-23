package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.exam.ExamApplyRequest;
import com.pytorch.gradingx.dto.exam.ExamSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Exam", description = "시험 관련 API")
@RestController
@RequestMapping("/api/exam")
public class ExamController {

    @Operation(summary = "시험 URL 조회", description = "examId를 이용하여 해당 시험의 URL을 조회합니다.")
    @GetMapping("/url/{examId}")
    public ResponseEntity<String> getExamURL(@PathVariable Long examId) {
        String testURL = "https://www.knu.ac.kr";
        return ResponseEntity.ok().body(testURL);
    }

    @Operation(summary = "시험 응시", description = "examId를 이용하여 해당 시험을 응시합니다.")
    @GetMapping("/{examId}")
    public ResponseEntity<Void> applyExam(@PathVariable Long examId, @RequestBody ExamApplyRequest examApplyRequest) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "시험 저장", description = "examId를 이용하여 해당 시험을 저장합니다.")
    @PostMapping("/{examId}/save")
    public ResponseEntity<Void> saveExam(@PathVariable Long examId, @RequestBody ExamSaveRequest examSaveRequest) {
        return ResponseEntity.ok().build();
    }
}
