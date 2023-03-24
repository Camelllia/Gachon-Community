package com.gachon.community.feed.exception;

public class FeedNotFoundException extends RuntimeException {

    private static final String MESSAGE = "삭제되었거나 존재하지 않는 게시글입니다.";

    public FeedNotFoundException() {
        super(MESSAGE);
    }

    public FeedNotFoundException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
