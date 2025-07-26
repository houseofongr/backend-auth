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

    @Override
    public String loadEmailAuthnCode(String email) {
        return valueOperations().get(EMAIL_AUTHN_CODE_PREFIX.getKey() + email);
    }

    @Override
    public boolean isAuthenticated(String email) {
        return Objects.equals(valueOperations().get(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email), EMAIL_AUTHENTICATED.getKey());
    }

    @Override
    public void saveEmailAuthnCode(String email, String code, Integer ttl) {
        valueOperations().set(EMAIL_AUTHN_CODE_PREFIX.getKey() + email, code, Duration.ofSeconds(ttl));
    }

    @Override
    public void saveAuthenticateStatus(String email, Boolean isAuthenticated, Integer ttl) {
        if (isAuthenticated)
            valueOperations().set(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email, EMAIL_AUTHENTICATED.getKey(), Duration.ofSeconds(ttl));
        else redisTemplate.delete(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email);
    }

    private ValueOperations<String, String> valueOperations() {
        return redisTemplate.opsForValue();
    }
}
