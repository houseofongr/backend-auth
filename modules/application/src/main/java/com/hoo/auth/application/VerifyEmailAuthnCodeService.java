package com.hoo.auth.application;

import com.hoo.auth.api.in.VerifyEmailAuthnCodeUseCase;
import com.hoo.auth.api.in.dto.VerifyEmailAuthnCodeResult;
import com.hoo.auth.api.out.LoadEmailAuthnPort;
import com.hoo.auth.api.out.SaveEmailAuthnPort;
import com.hoo.auth.application.exception.ApplicationErrorCode;
import com.hoo.auth.application.exception.AuthApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VerifyEmailAuthnCodeService implements VerifyEmailAuthnCodeUseCase {

    private final LoadEmailAuthnPort loadEmailAuthnPort;
    private final SaveEmailAuthnPort saveEmailAuthnPort;

    @Override
    public VerifyEmailAuthnCodeResult verify(String email, String code) {

        String codeInCache = loadEmailAuthnPort.loadEmailAuthnCode(email);

        if (!Objects.equals(codeInCache, code))
            throw new AuthApplicationException(ApplicationErrorCode.EMAIL_CODE_AUTHENTICATION_FAILED);

        Integer ttl = saveEmailAuthnPort.saveAuthenticateStatus(email);

        return new VerifyEmailAuthnCodeResult("이메일 인증에 성공했습니다.", ttl);
    }
}
