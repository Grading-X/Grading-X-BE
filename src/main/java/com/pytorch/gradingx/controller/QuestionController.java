package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.question.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Question", description = "문제 관련 API")
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Operation(summary = "문제 생성", description = "문제를 생성합니다.")
    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionRequest questionRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "문제 목록 조회", description = "assignmentId를 이용하여 해당 과제의 문제 목록을 조회합니다.")
    @GetMapping("/{assignmentId}")
    public ResponseEntity<QuestionListResponse> findQuestionList(@PathVariable long assignmentId){
        return ResponseEntity.ok(new QuestionListResponse());
    }

    @Operation(summary = "문제 채점기준 조회", description = "questionId를 이용하여 해당 문제의 채점기준(모범답안, 키워드)리스트를 조회합니다.")
    @GetMapping("/criteria/{questionId}")
    public ResponseEntity<QuestionCriteriaResponse> getQuestionCriteria(@PathVariable long questionId){
        return ResponseEntity.ok(new QuestionCriteriaResponse());
    }

    @Operation(summary = "문제 상세 조회", description = "questionId를 이용하여 해당 문제의 상세 정보를 조회합니다.")
    @GetMapping("/{questionId}/{guestEmail}")
    public ResponseEntity<QuestionGuestAnswerResponse> getQuestionGuestAnswer(@PathVariable long questionId, @PathVariable String guestEmail){
        return ResponseEntity.ok(new QuestionGuestAnswerResponse());
    }

    @Operation(summary = "문제 수정", description = "questionId를 이용하여 해당 문제를 수정합니다.")
    @PutMapping("/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable long questionId, @RequestBody QuestionRequest questionRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "문제 삭제", description = "questionId를 이용하여 해당 문제를 삭제합니다.")
    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable long questionId){
        return ResponseEntity.ok().build();
    }


}
