package com.hoo.auth.application;

import com.hoo.auth.api.out.EncryptPort;
import com.hoo.auth.api.out.SaveBusinessUserCredentialPort;
import com.hoo.auth.api.out.SaveEmailAuthnPort;
import com.hoo.auth.domain.BusinessUserCredential;
import com.hoo.common.internal.api.auth.RegisterBusinessUserCredentialAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterBusinessUserCredentialService implements RegisterBusinessUserCredentialAPI {

    private final SaveBusinessUserCredentialPort saveBusinessUserCredentialPort;
    private final SaveEmailAuthnPort saveEmailAuthnPort;
    private final EncryptPort encryptPort;

    @Override
    public void saveBusinessUserPassword(String email, String password) {
        String encryptedPassword = encryptPort.encrypt(password);
        BusinessUserCredential businessUserCredential = BusinessUserCredential.create(email, encryptedPassword);

        saveBusinessUserCredentialPort.saveBusinessUserCredential(businessUserCredential);
        saveEmailAuthnPort.saveAuthenticateStatus(email, false, null);
    }
}
