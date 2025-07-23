package com.hoo.auth.api.out;

import com.hoo.auth.domain.BusinessUserCredential;

public interface SaveBusinessUserCredentialPort {
    void saveBusinessUserCredential(BusinessUserCredential businessUserCredential);
}
