package com.hoo.auth.api.out;

import com.hoo.common.internal.api.user.dto.UserInfo;

import java.util.UUID;

public interface LoadBusinessUserCredentialPort {
    UserInfo findUserInfo(UUID userID);
}
