package com.hoo.auth.adapter.in.web;

import com.hoo.auth.api.in.CreateEmailAuthnCodeUseCase;
import com.hoo.auth.api.in.dto.CreateEmailAuthnCodeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateEmailAuthnCodeController {

    private final CreateEmailAuthnCodeUseCase useCase;

    @PostMapping("/auth/email-authn-code")
    ResponseEntity<CreateEmailAuthnCodeResult> create(
            @RequestParam String email
    ) {

        return ResponseEntity.ok(useCase.createEmailAuthnCode(email));
    }
}
