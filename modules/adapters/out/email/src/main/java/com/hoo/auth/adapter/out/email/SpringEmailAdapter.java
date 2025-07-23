package com.hoo.auth.adapter.out.email;

import com.hoo.auth.api.out.SendAuthnCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RequiredArgsConstructor
public class SpringEmailAdapter implements SendAuthnCodePort {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendAuthnCode(String emailAddress, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setSubject("HOO 메일인증 요청");
        msg.setTo(emailAddress);
        msg.setText(String.format("인증번호는 [%s]입니다.", message));

        javaMailSender.send(msg);
    }
}
