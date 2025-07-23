package com.hoo.auth.api.in;

import com.hoo.auth.api.in.dto.VerifyEmailAuthnCodeResult;

public interface VerifyEmailAuthnCodeUseCase {
    VerifyEmailAuthnCodeResult verify(String email, String code);
}
