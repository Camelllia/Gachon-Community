package com.gachon.community.member.repository;

import com.gachon.community.member.domain.Member;

import java.util.Optional;

public interface MemberCustomRepository {

    Optional<Member> existByEmailAndNickname(String email, String nickname);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByMemberId(Long id);

    long delete(Long id);
}
