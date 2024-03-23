package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.dto.member.MemberUpdateRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "회원 관련 API")
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Operation(summary = "회원 정보 조회", description = "로그인한 회원의 정보를 조회합니다.")
    @GetMapping
    public ResponseEntity<MemberInfoResponse> getMemberInfo(){
        return ResponseEntity.ok(new MemberInfoResponse());
    }

    @Operation(summary = "회원 정보 수정", description = "로그인한 회원의 정보를 수정합니다.")
    @PutMapping
    public ResponseEntity updateMemberInfo(@RequestBody MemberUpdateRequest memberUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "회원 탈퇴", description = "로그인한 유저의 회원 탈퇴합니다.")
    @DeleteMapping
    public ResponseEntity deleteMember(){
        return ResponseEntity.ok().build();
    }
}
