package com.hoo.auth.adapter.in.web;

import com.hoo.common.internal.api.auth.RegisterBusinessUserCredentialAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterBusinessUserCredentialController {

    private final RegisterBusinessUserCredentialAPI registerBusinessUserCredentialAPI;

    @PostMapping("/auth/register/business-user")
    ResponseEntity<Void> register(
            @RequestParam String email,
            @RequestParam String password) {

        registerBusinessUserCredentialAPI.saveBusinessUserPassword(email, password);
        return ResponseEntity.ok().build();
    }
}
