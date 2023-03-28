package com.gachon.community.menu.exception;

public class OverlapMenuNameException extends RuntimeException {

    private static final String MESSAGE = "이미 존재하는 메뉴 이름입니다.";

    public OverlapMenuNameException() {
        super(MESSAGE);
    }

    public OverlapMenuNameException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
