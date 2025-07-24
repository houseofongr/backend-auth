package com.hoo.auth.adapter.in.web;

import com.hoo.auth.api.in.VerifyEmailAuthnCodeUseCase;
import com.hoo.auth.api.in.dto.VerifyEmailAuthnCodeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VerifyEmailAuthnCodeController {

    private final VerifyEmailAuthnCodeUseCase useCase;

    @PostMapping("/auth/email-authn-code/verify")
    ResponseEntity<VerifyEmailAuthnCodeResult> verify(
            @RequestParam String email,
            @RequestParam String code
    ) {

        return ResponseEntity.ok(useCase.verify(email, code));
    }
}
