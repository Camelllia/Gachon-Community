package com.gachon.community.member.exception;

public class MemberNotFoundException extends RuntimeException {

    private static final String MESSAGE = "해당 유저를 찾을 수 없습니다.";

    public MemberNotFoundException() {
        super(MESSAGE);
    }

    public MemberNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
