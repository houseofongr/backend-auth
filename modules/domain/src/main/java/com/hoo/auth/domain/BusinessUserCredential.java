package com.hoo.auth.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "email")
public class BusinessUserCredential {

    private final String email;
    private final String encryptedPassword;

    public static BusinessUserCredential create(String email, String encryptedPassword) {
        return new BusinessUserCredential(email, encryptedPassword);
    }

}
