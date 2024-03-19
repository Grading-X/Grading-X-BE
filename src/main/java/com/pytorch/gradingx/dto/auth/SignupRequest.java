package com.pytorch.gradingx.dto.auth;

import com.pytorch.gradingx.domain.enumeration.MemberType;

public class SignupRequest {
    public String email;
    public String password;
    public String name;
    public MemberType memberType;
}
