package com.hoo.auth.adapter.out.cache;

import com.hoo.auth.api.out.LoadEmailAuthnPort;
import com.hoo.auth.api.out.SaveEmailAuthnPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.util.Objects;

import static com.hoo.common.enums.CacheKeys.*;

@RequiredArgsConstructor
public class RedisAdapter implements SaveEmailAuthnPort, LoadEmailAuthnPort {

    private final RedisTemplate<String, String> redisTemplate;
    private final EmailProperties emailProperties;

    @Override
    public String loadEmailAuthnCode(String email) {
        return valueOperations().get(EMAIL_AUTHN_CODE_PREFIX.getKey() + email);
    }

    @Override
    public boolean isAuthenticated(String email) {
        return Objects.equals(valueOperations().get(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email), EMAIL_AUTHENTICATED.getKey());
    }

    @Override
    public Integer saveEmailAuthnCode(String email, String code) {

        Integer ttl = emailProperties.authn().code().ttl();
        valueOperations().set(EMAIL_AUTHN_CODE_PREFIX.getKey() + email, code, Duration.ofSeconds(ttl));

        return ttl;
    }

    @Override
    public Integer saveAuthenticateStatus(String email) {

        Integer ttl = emailProperties.authn().status().ttl();
        valueOperations().set(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email, EMAIL_AUTHENTICATED.getKey(), Duration.ofSeconds(ttl));

        return ttl;
    }

    private ValueOperations<String, String> valueOperations() {
        return redisTemplate.opsForValue();
    }
}
