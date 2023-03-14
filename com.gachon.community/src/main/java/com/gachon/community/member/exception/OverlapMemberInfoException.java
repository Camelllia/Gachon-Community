package com.gachon.community.member.exception;

public class OverlapMemberInfoException extends RuntimeException {

    private static final String CODE = "-30";

    public OverlapMemberInfoException() {
        super(CODE);
    }
}
