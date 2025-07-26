package com.hoo.auth.application;

import com.hoo.auth.api.in.CreateEmailAuthnCodeUseCase;
import com.hoo.auth.api.in.dto.CreateEmailAuthnCodeResult;
import com.hoo.auth.api.out.SaveEmailAuthnPort;
import com.hoo.auth.api.out.SendAuthnCodePort;
import com.hoo.auth.domain.EmailAuthnCode;
import com.hoo.auth.application.exception.ApplicationErrorCode;
import com.hoo.auth.application.exception.AuthApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmailAuthnCodeService implements CreateEmailAuthnCodeUseCase {

    private final SaveEmailAuthnPort saveEmailAuthnPort;
    private final SendAuthnCodePort sendAuthnCodePort;
    private final ApplicationProperties applicationProperties;

    @Override
    public CreateEmailAuthnCodeResult createEmailAuthnCode(String email) {

        validate(email);

        EmailAuthnCode emailAuthnCode = EmailAuthnCode.create();

        sendAuthnCodePort.sendAuthnCode(email, emailAuthnCode.getCode());

        Integer ttl = applicationProperties.codeTtl();
        saveEmailAuthnPort.saveEmailAuthnCode(email, emailAuthnCode.getCode(), ttl);

        return new CreateEmailAuthnCodeResult(
                String.format("[이메일 : %s]로 인증코드 전송이 완료되었습니다.", email),
                ttl);
    }

    private void validate(String email) {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
            throw new AuthApplicationException(ApplicationErrorCode.INVALID_EMAIL_ADDRESS);
    }
}
