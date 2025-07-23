package com.hoo.auth.api.in.dto;

public record CreateEmailAuthnCodeResult(
        String message,
        Integer ttl
) {
}
