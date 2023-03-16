package com.gachon.community.member.exception;

public class UnAuthenticatedUserException extends RuntimeException {

    private static final String MESSAGE = "인증되지 않은 유저입니다.";

    public UnAuthenticatedUserException() {
        super(MESSAGE);
    }

    public UnAuthenticatedUserException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
