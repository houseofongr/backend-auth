package com.hoo.auth.adapter.out.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

import static com.hoo.common.enums.CacheKeys.*;
import static org.assertj.core.api.Assertions.assertThat;

@RedisTest
class RedisAdapterTest {

    @Autowired
    RedisAdapter sut;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @BeforeEach
    void clear() {
        Set<String> keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
    }

    @Test
    @DisplayName("이메일 인증코드 저장 테스트")
    void testSaveAuthnEmailCode() {
        // given
        String email = "test@example.com";
        String code = "123456";

        // when
        sut.saveEmailAuthnCode(email, code);

        // then
        assertThat(redisTemplate.opsForValue().get(EMAIL_AUTHN_CODE_PREFIX.getKey() + email)).isEqualTo(code);
        assertThat(redisTemplate.getExpire(EMAIL_AUTHN_CODE_PREFIX.getKey() + email)).isEqualTo(600);
    }

    @Test
    @DisplayName("이메일 인증코드 불러오기 테스트")
    void testLoadAuthnEmailCode() {
        // given
        String email = "test@example.com";
        String code = "123456";
        sut.saveEmailAuthnCode(email, code);

        // when
        String result = sut.loadEmailAuthnCode(email);

        // then
        assertThat(result).isEqualTo(code);
    }

    @Test
    @DisplayName("이메일 인증완료 테스트")
    void testSaveAuthnStatus() {
        // given
        String email = "test@example.com";

        // when
        sut.saveAuthenticateStatus(email);

        // then
        assertThat(redisTemplate.opsForValue().get(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email)).isEqualTo(EMAIL_AUTHENTICATED.getKey());
        assertThat(redisTemplate.getExpire(EMAIL_AUTHN_STATUS_PREFIX.getKey() + email)).isEqualTo(3600);
    }

    @Test
    @DisplayName("이메일 인증여부 확인 테스트")
    void testLoadAuthnStatus() {
        // given
        String email = "test@example.com";

        // when 1 : not saved
        assertThat(sut.isAuthenticated(email)).isFalse();

        // when 2 : saved
        sut.saveAuthenticateStatus(email);

        // then
        assertThat(sut.isAuthenticated(email)).isTrue();
    }
}