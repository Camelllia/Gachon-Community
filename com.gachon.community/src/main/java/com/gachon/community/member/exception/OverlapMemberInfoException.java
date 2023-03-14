package com.gachon.community.member.exception;

public class OverlapMemberInfoException extends RuntimeException {

    private static final String MESSAGE = "같은 이메일 또는 닉네임을 가진 유저가 존재합니다.";

    public OverlapMemberInfoException() {
        super(MESSAGE);
    }

    public OverlapMemberInfoException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
