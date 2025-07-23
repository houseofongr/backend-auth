package com.hoo.auth.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailAuthnCodeTest {

    @Test
    @DisplayName("6자리 코드 생성")
    void create() {
        // when
        EmailAuthnCode code = EmailAuthnCode.create();

        // then
        assertThat(code.getCode())
                .hasSize(6)
                .matches("\\d{6}");
    }
}