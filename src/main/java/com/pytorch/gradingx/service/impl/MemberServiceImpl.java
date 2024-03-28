package com.pytorch.gradingx.service.impl;

import com.pytorch.gradingx.domain.Member;
import com.pytorch.gradingx.dto.auth.SignupRequest;
import com.pytorch.gradingx.dto.member.MemberInfoResponse;
import com.pytorch.gradingx.dto.member.MemberUpdateRequest;
import com.pytorch.gradingx.repository.MemberRepository;
import com.pytorch.gradingx.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public boolean checkMember(String email, String password) {
        return getMemberByEmail(email).validatePassword(password);
    }

    @Override
    public void saveRefreshToken(String email, String refreshToken) {
        Member member = getMemberByEmail(email);
        member.setRefreshToken(refreshToken);
        memberRepository.save(member);
    }

    @Override
    public void deleteRefreshToken(String email) {
        Member member = getMemberByEmail(email);
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

    @Override
    public MemberInfoResponse findMemberInfo(String email) {
        Member member = getMemberByEmail(email);
        MemberInfoResponse memberInfoResponse = new MemberInfoResponse();
        member.setInfoDto(memberInfoResponse);
        return memberInfoResponse;
    }

    @Override
    public void updateMemberInfo(MemberUpdateRequest memberUpdateRequest, String email) {
        Member member = getMemberByEmail(email);
        member.updateInfo(memberUpdateRequest);
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(String email) {
        Member member = getMemberByEmail(email);
        memberRepository.delete(member);
    }

    private Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
