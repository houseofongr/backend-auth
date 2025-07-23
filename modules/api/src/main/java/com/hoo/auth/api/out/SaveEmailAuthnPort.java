package com.hoo.auth.api.out;

public interface SaveEmailAuthnPort {
    Integer saveEmailAuthnCode(String email, String code);

    Integer saveAuthenticateStatus(String email);
}
