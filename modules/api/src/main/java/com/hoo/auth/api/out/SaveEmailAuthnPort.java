package com.hoo.auth.api.out;

public interface SaveEmailAuthnPort {
    void saveEmailAuthnCode(String email, String code, Integer ttl);

    void saveAuthenticateStatus(String email, Boolean isAuthenticated, Integer ttl);
}
