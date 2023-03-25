package com.gachon.community.exception.controller;

import com.gachon.community.board.exception.BoardNotFoundException;
import com.gachon.community.exception.response.ErrorResponse;
import com.gachon.community.feed.exception.FeedNotFoundException;
import com.gachon.community.feed.exception.InvalidExtensionException;
import com.gachon.community.game.exception.GameMemberNotFoundException;
import com.gachon.community.member.exception.*;
import com.gachon.community.menu.exception.MenuNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message("입력되지 않은 정보가 있습니다.")
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordMismatchException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(PasswordMismatchException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OverlapMemberInfoException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(OverlapMemberInfoException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmailPatternException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(InvalidEmailPatternException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(MemberNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MenuNotFoundException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(MenuNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(BoardNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthenticatedUserException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(UnAuthenticatedUserException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("403")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidExtensionException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(InvalidExtensionException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FeedNotFoundException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(FeedNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GameMemberNotFoundException.class)
    @ResponseBody
    public ErrorResponse invaildRequestHandler(GameMemberNotFoundException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();

        return errorResponse;
    }
}
