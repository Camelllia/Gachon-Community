package com.gachon.community.member.exception;

public class InvaildEmailPatternException extends RuntimeException {

    private static final String MESSAGE = "이메일 형식이 아닙니다.";

    public InvaildEmailPatternException() {
        super(MESSAGE);
    }

    public InvaildEmailPatternException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
