package com.gachon.community.member.service;

import com.gachon.community.member.domain.Member;
import com.gachon.community.member.exception.OverlapMemberInfoException;
import com.gachon.community.member.exception.PasswordMismatchException;
import com.gachon.community.member.repository.MemberRepository;
import com.gachon.community.member.request.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> join(MemberCreateRequest request) {

        // 비밀번호 체크
        if(!request.getPassword().equals(request.getPasswordCheck())) {
            throw new PasswordMismatchException();
        }

        // 존재하는 이메일/닉네임
        if(memberRepository.existByEmailAndNickname(request.getEmail(), request.getNickname()).isPresent()) {
            throw new OverlapMemberInfoException();
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build();

        memberRepository.save(member);

        log.info("NEW MEMBER CREATE : {}", member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
