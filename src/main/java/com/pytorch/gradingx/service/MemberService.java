package com.pytorch.gradingx.service;

public interface MemberService {
    boolean checkMember(String email, String password);
    void saveRefreshToken(String email, String refreshToken);
}
