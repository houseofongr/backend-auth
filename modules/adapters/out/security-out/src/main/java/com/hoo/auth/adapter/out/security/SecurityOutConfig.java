package com.hoo.auth.adapter.out.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityOutConfig {

    @Bean
    SpringSecurityAdapter springSecurityEncryptAdapter(PasswordEncoder passwordEncoder) {
        return new SpringSecurityAdapter(passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
