package com.hoo.auth.adapter.out.email;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@EnableConfigurationProperties(EmailProperties.class)
public class EmailConfig {

    @Bean
    public JavaMailAdapter emailAdapter(JavaMailSender javaMailSender) {
        return new JavaMailAdapter(javaMailSender);
    }

    @Bean
    JavaMailSender mailSender(EmailProperties emailProperties) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailProperties.host());
        mailSender.setPort(emailProperties.port());
        mailSender.setUsername(emailProperties.username());
        mailSender.setPassword(emailProperties.password());

        Properties properties = new Properties();
        properties.putAll(emailProperties.properties());

        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
