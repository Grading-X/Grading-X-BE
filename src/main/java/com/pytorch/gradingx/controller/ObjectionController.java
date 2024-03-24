package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.objection.ObjectionCreateRequest;
import com.pytorch.gradingx.dto.objection.ObjectionListResponse;
import com.pytorch.gradingx.dto.objection.ObjectionReplyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Objection", description = "이의 관련 API")
@RestController
@RequestMapping("/api/objection")
public class ObjectionController {

    @Operation(summary = "이의 생성", description = "이의(해당하는 문제id, 게스트email, 제목, 내용)를 요청받아 이의 생성")
    @PostMapping
    public ResponseEntity createObjection(@RequestBody ObjectionCreateRequest objectionCreateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "이의 목록 조회", description = "guestEmail을 이용하여 해당 게스트의 이의 목록 조회(게스트)")
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByGuest(@PathVariable String guestEmail){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @Operation(summary = "이의 목록 조회", description = "courseId에 해당하는 과목의 이의 목록 조회(교수자)")
    @GetMapping("/course/{courseId}")
    public ResponseEntity<ObjectionListResponse> findObjectionListByCourse(@PathVariable long courseId){
        return ResponseEntity.ok(new ObjectionListResponse());
    }

    @Operation(summary = "이의 답변", description = "objectionId에 해당하는 의의 답변(제목, 내용)을 게스트 이메일로 전송")
    @PostMapping("/{objectionId}")
    public ResponseEntity updateObjection(@PathVariable long objectionId, @RequestBody ObjectionReplyRequest objectionReplyRequest){
        return ResponseEntity.ok().build();
    }

}
