package com.gachon.community.member.exception;

public class PasswordMismatchException extends RuntimeException {

    private static final String MESSAGE = "입력하신 두 비밀번호가 일치하지 않습니다.";

    public PasswordMismatchException() {
        super(MESSAGE);
    }

    public PasswordMismatchException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
