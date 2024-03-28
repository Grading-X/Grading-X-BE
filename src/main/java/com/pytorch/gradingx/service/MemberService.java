package com.pytorch.gradingx.service;

import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import com.pytorch.gradingx.dto.member.MemberUpdateRequest;

public interface MemberService {
    boolean checkMember(String email, String password);
    void saveRefreshToken(String email, String refreshToken);
    void deleteRefreshToken(String email);
    void signup(SignupRequest request);
    MemberInfoResponse findMemberInfo(String email);
    void updateMemberInfo(MemberUpdateRequest memberUpdateRequest, String email);
    void deleteMember(String email);
}
