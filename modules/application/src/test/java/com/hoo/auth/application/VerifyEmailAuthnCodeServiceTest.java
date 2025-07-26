package com.hoo.auth.application;

import com.hoo.auth.application.VerifyEmailAuthnCodeService;
import com.hoo.auth.api.out.LoadEmailAuthnPort;
import com.hoo.auth.api.out.SaveEmailAuthnPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class VerifyEmailAuthnCodeServiceTest {

    private LoadEmailAuthnPort loadEmailAuthnPort = mock();
    private SaveEmailAuthnPort saveEmailAuthnPort = mock();
    ApplicationProperties applicationProperties = mock();

    VerifyEmailAuthnCodeService sut = new VerifyEmailAuthnCodeService(loadEmailAuthnPort, saveEmailAuthnPort, applicationProperties);

    @Test
    @DisplayName("이메일 인증 코드 확인 서비스")
    void verifyEmailAuthnCodeService() {
        // given
        String email = "test@example.com";
        String code = "123456";

        // when
        when(loadEmailAuthnPort.loadEmailAuthnCode(email)).thenReturn(code);
        sut.verify(email, code);

        // then
        verify(saveEmailAuthnPort, times(1)).saveAuthenticateStatus(anyString(), anyBoolean(), anyInt());
    }
}