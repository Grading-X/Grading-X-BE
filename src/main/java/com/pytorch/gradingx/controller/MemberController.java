package com.pytorch.gradingx.controller;

import com.pytorch.gradingx.annotation.TokenEmail;
import com.pytorch.gradingx.dto.member.MemberUpdateRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import com.pytorch.gradingx.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "회원 관련 API")
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "회원 정보 조회", description = "로그인한 회원의 정보를 조회합니다.")
    @GetMapping
    public ResponseEntity<MemberInfoResponse> getMemberInfo(@TokenEmail String email){
        return ResponseEntity.ok(memberService.findMemberInfo(email));
    }

    @Operation(summary = "회원 정보 수정", description = "로그인한 회원의 정보를 수정합니다.")
    @PutMapping
    public ResponseEntity updateMemberInfo(@RequestBody MemberUpdateRequest memberUpdateRequest, @TokenEmail String email){
        memberService.updateMemberInfo(memberUpdateRequest, email);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "회원 탈퇴", description = "로그인한 유저의 회원 탈퇴")
    @DeleteMapping
    public ResponseEntity deleteMember(@TokenEmail String email){
        memberService.deleteMember(email);
        return ResponseEntity.ok().build();
    }
}
