package com.hoo.auth.api.in;

import com.hoo.auth.api.in.dto.CreateEmailAuthnCodeResult;

public interface CreateEmailAuthnCodeUseCase {
    CreateEmailAuthnCodeResult createEmailAuthnCode(String email);
}
