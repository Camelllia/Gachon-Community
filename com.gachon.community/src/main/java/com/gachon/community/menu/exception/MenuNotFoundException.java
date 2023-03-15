package com.gachon.community.menu.exception;

public class MenuNotFoundException extends RuntimeException {

    private static final String MESSAGE = "삭제되었거나 존재하지 않는 메뉴입니다.";

    public MenuNotFoundException() {
        super(MESSAGE);
    }

    public MenuNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
