package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.examcontent.ExamContentCreateRequest;
import com.pytorch.gradingx.dto.examcontent.ExamContentInfoResponse;
import com.pytorch.gradingx.dto.examcontent.ExamContentListResponse;
import com.pytorch.gradingx.dto.examcontent.ExamContentUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ExamContent", description = "시험 관련 API")
@RestController
@RequestMapping("/api/exam-content")
public class ExamContentController {

    @Operation(summary = "시험 목록 조회(회원)", description = "courseId를 이용하여 해당 과목의 시험(id, 이름, 시작-종료시간)의 목록 반환")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<ExamContentListResponse> findExamContentListByCourse(@PathVariable long courseId){
//        return ResponseEntity.ok(new ExamContentListResponse());
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "시험 목록 조회(게스트)", description = "이의제기 화면을 위해 guestEmail을 입력받아 해당 게스트가 응시한 시험(id, 이름, 시작-종료시간)의 목록 반환")
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<ExamContentListResponse> findExamContentListByGuest(@PathVariable String guestEmail){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "시험 상세 조회", description = "ExamContentId를 입력받아 해당 시험의 id, 이름, 설명, 시작-종료시간을 반환")
    @GetMapping("/{examContentId}")
    public ResponseEntity<ExamContentInfoResponse> getExamContentInfo(@PathVariable long examContentId){
        throw new UnsupportedOperationException("Not implemented");
    }

    @Operation(summary = "시험 생성", description = "이름, 설명, 시작-종료 시간을 입력받아 시험를 생성 후 해당 시험의 id를 반환")
    @PostMapping
    public ResponseEntity<Long> createExamContent(@RequestBody ExamContentCreateRequest examContentCreateRequest){
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "시험 정보 수정", description = "examContentId와 이름, 설명, 시작-종료 시간을 입력받아 해당 시험의 정보를 수정 후 해당 시험의 id를 반환")
    @PutMapping("/{examContentId}")
    public ResponseEntity<Long> updateExamContentInfo(@PathVariable long examContentId, @RequestBody ExamContentUpdateRequest examContentUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "시험 삭제", description = "ExamContentId를 입력받아 해당 시험를 삭제")
    @DeleteMapping("/{examContentId}")
    public ResponseEntity deleteExamContent(@PathVariable long examContentId){
        return ResponseEntity.ok().build();
    }
}
