package com.gachon.community.member.exception;

public class PasswordMismatchException extends RuntimeException {

    private static final String CODE = "-20";

    public PasswordMismatchException() {
        super(CODE);
    }
}
