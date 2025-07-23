package com.hoo.auth.api.out;

public interface LoadEmailAuthnPort {
    String loadEmailAuthnCode(String email);
    boolean isAuthenticated(String email);
}
