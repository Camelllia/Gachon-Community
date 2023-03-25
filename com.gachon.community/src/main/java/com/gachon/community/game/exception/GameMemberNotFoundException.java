package com.gachon.community.game.exception;

public class GameMemberNotFoundException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 유저입니다.";

    public GameMemberNotFoundException() {
        super(MESSAGE);
    }

    public GameMemberNotFoundException(Throwable cause) {
        super(MESSAGE, cause);}
}
