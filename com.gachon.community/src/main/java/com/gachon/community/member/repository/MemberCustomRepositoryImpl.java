package com.gachon.community.member.repository;

import com.gachon.community.member.domain.Member;
import static com.gachon.community.member.domain.QMember.member;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.Optional;

public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Member> existByEmailAndNickname(String email, String nickname) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.email.eq(email).or(member.nickname.eq(nickname)))
                .where(member.delYn.eq(Boolean.FALSE))
                .fetchOne());
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.email.eq(email))
                .where(member.delYn.eq(Boolean.FALSE))
                .fetchOne());
    }

    @Override
    public Optional<Member> findByMemberId(Long id) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(member)
                .where(member.id.eq(id))
                .where(member.delYn.eq(Boolean.FALSE))
                .fetchOne());
    }

    @Override
    public long delete(Long id) {
        return jpaQueryFactory.update(member)
                .set(member.delYn, Boolean.TRUE)
                .set(member.deleteDate, Expressions.currentTimestamp())
                .where(member.id.eq(id))
                .execute();
    }
}
