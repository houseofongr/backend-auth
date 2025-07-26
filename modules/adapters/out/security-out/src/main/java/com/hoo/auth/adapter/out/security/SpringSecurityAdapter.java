package com.hoo.auth.adapter.out.security;

import com.hoo.auth.api.out.EncryptPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class SpringSecurityAdapter implements EncryptPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encrypt(String plain) {
        return passwordEncoder.encode(plain);
    }
}
