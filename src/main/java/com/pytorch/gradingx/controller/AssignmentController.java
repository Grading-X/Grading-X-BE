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

    @Operation(summary = "과제 목록 조회(회원)", description = "courseId를 이용하여 해당 과목의 과제 목록을 조회합니다.")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<AssignmentListResponse> findAssignmentListByCourse(@PathVariable long courseId){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @Operation(summary = "과제 목록 조회(게스트)", description = "guestEmail을 이용하여 해당 게스트의 과제 목록을 조회합니다.")
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<AssignmentListResponse> findAssignmentListByGuest(@PathVariable String guestEmail){
        return ResponseEntity.ok(new AssignmentListResponse());
    }

    @Operation(summary = "과제 상세 조회", description = "assignmentId를 이용하여 해당 과제의 상세 정보를 조회합니다.")
    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentInfoResponse> getAssignmentInfo(@PathVariable long assignmentId){
        return ResponseEntity.ok(new AssignmentInfoResponse());
    }

    @Operation(summary = "과제 생성", description = "과제를 생성합니다.")
    @PostMapping
    public ResponseEntity<Long> createAssignment(@RequestBody AssignmentCreateRequest assignmentCreateRequest){
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "과제 정보 수정", description = "assignmentId를 이용하여 해당 과제의 정보를 수정합니다.")
    @PutMapping("/{assignmentId}")
    public ResponseEntity updateAssignmentInfo(@PathVariable long assignmentId, @RequestBody AssignmentUpdateRequest assignmentUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "과제 삭제", description = "assignmentId를 이용하여 해당 과제를 삭제합니다.")
    @DeleteMapping("/{assignmentId}")
    public ResponseEntity deleteAssignment(@PathVariable long assignmentId){
        return ResponseEntity.ok().build();
    }
}
