package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.assignment.AssignmentCreateRequest;
import com.pytorch.gradingx.dto.assignment.AssignmentInfoResponse;
import com.pytorch.gradingx.dto.assignment.AssignmentListResponse;
import com.pytorch.gradingx.dto.assignment.AssignmentUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Assignment", description = "과제 관련 API")
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Operation(summary = "과제 목록 조회(회원)", description = "courseId를 이용하여 해당 과목의 과제(id, 이름, 시작-종료시간)의 목록 반환")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<AssignmentListResponse> findAssignmentListByCourse(@PathVariable long courseId){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @Operation(summary = "과제 목록 조회(게스트)", description = "이의제기 화면을 위해 guestEmail을 입력받아 해당 게스트가 응시한 과제(id, 이름, 시작-종료시간)의 목록 반환")
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<AssignmentListResponse> findAssignmentListByGuest(@PathVariable String guestEmail){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @Operation(summary = "과제 상세 조회", description = "assignmentId를 입력받아 해당 과제의 id, 이름, 설명, 시작-종료시간을 반환")
    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentInfoResponse> getAssignmentInfo(@PathVariable long assignmentId){
        return ResponseEntity.ok(new AssignmentInfoResponse());
    }

    @Operation(summary = "과제 생성", description = "이름, 설명, 시작-종료 시간을 입력받아 과제를 생성 후 해당 과제의 id를 반환")
    @PostMapping
    public ResponseEntity<Long> createAssignment(@RequestBody AssignmentCreateRequest assignmentCreateRequest){
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "과제 정보 수정", description = "assignmentId와 이름, 설명, 시작-종료 시간을 입력받아 해당 과제의 정보를 수정 후 해당 과제의 id를 반환")
    @PutMapping("/{assignmentId}")
    public ResponseEntity<Long> updateAssignmentInfo(@PathVariable long assignmentId, @RequestBody AssignmentUpdateRequest assignmentUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "과제 삭제", description = "assignmentId를 입력받아 해당 과제를 삭제")
    @DeleteMapping("/{assignmentId}")
    public ResponseEntity deleteAssignment(@PathVariable long assignmentId){
        return ResponseEntity.ok().build();
    }
}
