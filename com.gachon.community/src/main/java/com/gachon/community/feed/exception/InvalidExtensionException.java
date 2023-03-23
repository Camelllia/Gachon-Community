package com.gachon.community.feed.exception;

public class InvalidExtensionException extends RuntimeException {

    private static final String MESSAGE = "PNG 또는 JPG 형식의 파일만 등록 가능합니다.";

    public InvalidExtensionException() {
        super(MESSAGE);
    }

    public InvalidExtensionException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
