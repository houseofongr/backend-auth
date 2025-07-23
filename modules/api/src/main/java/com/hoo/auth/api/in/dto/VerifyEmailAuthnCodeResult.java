package com.hoo.auth.api.in.dto;

public record VerifyEmailAuthnCodeResult(
        String message,
        Integer ttl
) {
}
