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

    @Operation(summary = "문제 생성", description = "질문, 번호, 배점, 모범답안리스트, 키워드리스트를 입력받아 문제를 생성")
    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionCreateRequest questionRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "문제 목록 조회", description = "assignmentId에 해당하는 과제의 문제(id, 질문, 번호, 배점)리스트 반환")
    @GetMapping("/{assignmentId}")
    public ResponseEntity<QuestionListResponse> findQuestionList(@PathVariable long assignmentId){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "문제 채점기준 조회", description = "questionId에 해당하는 문제의 채점기준(모범답안, 키워드)리스트를 반환")
    @GetMapping("/criteria/{questionId}")
    public ResponseEntity<QuestionCriteriaResponse> getQuestionCriteria(@PathVariable long questionId){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "문제 상세 조회", description = "guestEmail에 해당하는 guest가 응시한 문제 중 questionId에 해당하는 문제의 본인 답변과 점수 반환")
    @GetMapping("/{questionId}/{guestEmail}")
    public ResponseEntity<QuestionGuestAnswerResponse> getQuestionGuestAnswer(@PathVariable long questionId, @PathVariable String guestEmail){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "문제 수정", description = "assignmentId에 해당하는 과제의 문제(questionId, 질문, 번호, 배점, 모범답변리스트, 키워드리스트)리스트를 입력받아 수정")
    @PutMapping("/{assignmentId}")
    public ResponseEntity updateQuestion(@PathVariable long assignmentId, @RequestBody QuestionUpdateRequest questionRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "문제 삭제", description = "questionId에 해당하는 문제를 삭제")
    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable long questionId){
        return ResponseEntity.ok().build();
    }


}
