package com.pytorch.gradingx.domain;

import com.pytorch.gradingx.domain.enumeration.MemberType;
import com.pytorch.gradingx.domain.enumeration.Vendor;
import jakarta.persistence.*;

@Entity
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Enumerated(EnumType.STRING)
    private Vendor vendor;

    private String vendorEmail;

    private String refreshToken;

    public boolean validatePassword(String password){
        return this.password.equals(password);
    }

    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}
