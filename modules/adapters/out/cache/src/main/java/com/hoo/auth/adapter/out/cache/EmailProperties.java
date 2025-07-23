package com.hoo.auth.adapter.out.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "email")
public record EmailProperties(
        Authn authn
) {

    public record Authn(
            Code code,
            Status status
    ) {

        public record Code(
                Integer ttl
        ) {

        }

        public record Status(
                Integer ttl
        ) {
        }

    }
}
