package com.pytorch.gradingx.service.impl;

import com.pytorch.gradingx.domain.Member;
import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.repository.MemberRepository;
import com.pytorch.gradingx.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public boolean checkMember(String email, String password) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return member.get().validatePassword(password);
    }

    @Override
    public void saveRefreshToken(String email, String refreshToken) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        member.get().setRefreshToken(refreshToken);
        memberRepository.save(member.get());
    }

    @Override
    public void signup(SignupRequest request) {
        Member member = new Member();
        member.signup(request);
        memberRepository.save(member);
    }
}
