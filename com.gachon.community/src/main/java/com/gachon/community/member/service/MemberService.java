package com.gachon.community.member.service;

import com.gachon.community.util.common.CommonUtil;
import com.gachon.community.member.domain.Member;
import com.gachon.community.member.exception.InvalidEmailPatternException;
import com.gachon.community.member.exception.MemberNotFoundException;
import com.gachon.community.member.exception.OverlapMemberInfoException;
import com.gachon.community.member.exception.PasswordMismatchException;
import com.gachon.community.member.provider.JwtTokenProvider;
import com.gachon.community.member.repository.MemberRepository;
import com.gachon.community.member.request.MemberCreateRequest;
import com.gachon.community.member.request.MemberLoginRequest;
import com.gachon.community.member.response.MemberResponse;
import com.gachon.community.member.response.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final CommonUtil commonUtil;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<?> join(MemberCreateRequest request) {

        // 비밀번호 체크
        if(!request.getPassword().equals(request.getPasswordCheck())) {
            throw new PasswordMismatchException();
        }

        // 이메일 형식 검사
        if(!commonUtil.isValidEmail(request.getEmail())) {
            throw new InvalidEmailPatternException();
        }

        // 존재하는 이메일/닉네임
        if(memberRepository.existByEmailAndNickname(request.getEmail(), request.getNickname()).isPresent()) {
            throw new OverlapMemberInfoException();
        }

        // 회원정보 객체 저장
        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .registIp(commonUtil.getIp())
                .role("ROLE_USER")
                .build();

        memberRepository.save(member);

        // 로깅
        log.info("NEW MEMBER REGISTRATION : {}", member);
        log.info("NEW MEMBER REGISTRATION IP : {}", commonUtil.getIp());

        return new ResponseEntity<>(new MemberResponse(member), HttpStatus.OK);
    }

    public ResponseEntity<?> login(MemberLoginRequest request) {

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(MemberNotFoundException::new);

        // 비밀번호 검사
        if(!passwordValidator(member, request.getPassword())) {
            throw new MemberNotFoundException();
        }

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        // 로깅
        log.info("MEMBER LOGIN : {}", member);
        log.info("MEMBER LOGIN IP : {}", commonUtil.getIp());

        return new ResponseEntity<>(tokenInfo, HttpStatus.OK);
    }

    public boolean passwordValidator(Member member, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, member.getPassword());
    }
}
