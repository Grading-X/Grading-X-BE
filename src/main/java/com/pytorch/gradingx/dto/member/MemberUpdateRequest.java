package com.pytorch.gradingx.dto.member;

import com.pytorch.gradingx.domain.enumeration.MemberType;

public class MemberUpdateRequest {
    public String email;
    public String name;
    public String password;
    public MemberType memberType;
}
