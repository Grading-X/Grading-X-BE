package com.pytorch.gradingx.service;

import com.pytorch.gradingx.dto.auth.SignupRequest;

public interface MemberService {
    boolean checkMember(String email, String password);
    void saveRefreshToken(String email, String refreshToken);
    void signup(SignupRequest request);
}
