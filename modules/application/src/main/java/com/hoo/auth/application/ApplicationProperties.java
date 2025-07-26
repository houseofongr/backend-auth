package com.hoo.auth.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "email.authn")
public record ApplicationProperties(
        Integer codeTtl,
        Integer statusTtl
) {
}
