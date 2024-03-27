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
        return findMemberByEmail(email).validatePassword(password);
    }

    @Override
    public void saveRefreshToken(String email, String refreshToken) {
        Member member = findMemberByEmail(email);
        member.setRefreshToken(refreshToken);
        memberRepository.save(member);
    }

    @Override
    public void deleteRefreshToken(String email) {
        Member member = findMemberByEmail(email);
        member.setRefreshToken(null);
        memberRepository.save(member);
    }

    @Override
    public void signup(SignupRequest request) {
        Optional<Member> optionalMember = memberRepository.findByEmail(request.email);
        if(optionalMember.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
        Member member = new Member();
        member.signup(request);
        memberRepository.save(member);
    }

    private Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
