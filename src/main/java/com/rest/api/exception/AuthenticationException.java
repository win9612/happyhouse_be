package com.rest.api.exception;

public class AuthenticationException extends RuntimeException {

    private final ErrorCode errorCode;

    public AuthenticationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
