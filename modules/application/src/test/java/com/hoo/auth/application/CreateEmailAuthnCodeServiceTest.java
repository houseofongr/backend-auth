package com.hoo.auth.application;

import com.hoo.auth.api.out.SaveEmailAuthnPort;
import com.hoo.auth.api.out.SendAuthnCodePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateEmailAuthnCodeServiceTest {

    SaveEmailAuthnPort saveEmailAuthnPort = mock();
    SendAuthnCodePort sendAuthnCodePort = mock();

    CreateEmailAuthnCodeService sut = new CreateEmailAuthnCodeService(saveEmailAuthnPort, sendAuthnCodePort);

    @Test
    @DisplayName("이메일 인증 코드 생성 서비스")
    void createEmailAuthnCodeService() {
        // given
        String email = "test@example.com";

        // when
        sut.createEmailAuthnCode(email);

        // then
        verify(sendAuthnCodePort, times(1)).sendAuthnCode(anyString(), anyString());
        verify(saveEmailAuthnPort, times(1)).saveEmailAuthnCode(anyString(), anyString());
    }

}