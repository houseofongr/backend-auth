package com.hoo.auth.adapter.in.web.errorcode;

import com.hoo.auth.application.exception.AuthAdapterException;
import com.hoo.auth.application.exception.AuthApplicationException;
import com.hoo.auth.application.exception.AuthDomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(AuthDomainException.class)
    public ResponseEntity<ErrorResponse> handle(AuthDomainException exception) {
        return ResponseEntity.status(exception.getError().getStatus()).body(ErrorResponse.of(exception.getError()));
    }

    @ExceptionHandler(AuthApplicationException.class)
    public ResponseEntity<ErrorResponse> handle(AuthApplicationException exception) {
        return ResponseEntity.status(exception.getError().getStatus()).body(ErrorResponse.of(exception.getError()));
    }

    @ExceptionHandler(AuthAdapterException.class)
    public ResponseEntity<ErrorResponse> handle(AuthAdapterException exception) {
        return ResponseEntity.status(exception.getError().getStatus()).body(ErrorResponse.of(exception.getError()));
    }
}
