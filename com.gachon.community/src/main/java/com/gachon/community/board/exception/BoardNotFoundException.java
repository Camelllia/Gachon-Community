package com.gachon.community.board.exception;

public class BoardNotFoundException extends RuntimeException {

    private static final String MESSAGE = "삭제되었거나 존재하지 않는 게시글입니다.";

    public BoardNotFoundException() {
        super(MESSAGE);
    }

    public BoardNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
