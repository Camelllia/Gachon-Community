package com.gachon.community.member.repository;

import com.gachon.community.member.domain.Member;
import static com.gachon.community.member.domain.QMember.member;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.Optional;

public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Optional<Member> existByEmailAndNickname(String email, String nickname) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.email.eq(email).or(member.nickname.eq(nickname)))
                .where(member.delYn.eq(Boolean.FALSE))
                .fetchOne());
    }
}
