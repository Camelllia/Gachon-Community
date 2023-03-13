package com.gachon.community.member.service;

import com.gachon.community.member.domain.Member;
import com.gachon.community.member.repository.MemberRepository;
import com.gachon.community.member.request.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity<?> join(MemberCreateRequest request) {

        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();

        memberRepository.save(member);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
