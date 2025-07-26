package com.hoo.auth.application.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class AuthApplicationException extends RuntimeException {

    private final ErrorCode error;
    private final String message;

    public AuthApplicationException(ErrorCode error) {
        log.error("Application Error : {}", error.getMessage());
        this.error = error;
        this.message = error.getMessage();
    }

    public AuthApplicationException(ErrorCode error, String message) {
        log.error("Application Error : {}", message);
        this.error = error;
        this.message = message;
    }

}
