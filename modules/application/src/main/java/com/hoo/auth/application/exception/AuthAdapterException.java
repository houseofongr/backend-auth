package com.hoo.auth.application.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class AuthAdapterException extends RuntimeException {
    private final AdapterErrorCode error;
    private final String message;

    public AuthAdapterException(AdapterErrorCode error) {
        log.error("Application Error : {}", error.getMessage());
        this.error = error;
        this.message = error.getMessage();
    }

    public AuthAdapterException(AdapterErrorCode error, String message) {
        log.error("Application Error : {}", message);
        this.error = error;
        this.message = message;
    }

}
