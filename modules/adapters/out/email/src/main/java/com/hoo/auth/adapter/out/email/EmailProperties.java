package com.hoo.auth.adapter.out.email;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "spring.mail")
public record EmailProperties(
        String host,
        Integer port,
        String username,
        String password,
        Map<String, String> properties
) {
}
