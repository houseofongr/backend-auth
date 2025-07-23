package com.hoo.auth.api.out;

public interface SendAuthnCodePort {
    void sendAuthnCode(String emailAddress, String message);
}
