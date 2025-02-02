package com.example.videoapiapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailCreatorService {

    private final JavaMailSender javaMailSender;
    private static final String MAIL_ADDRESS = "apicarrentalservice@onet.pl";
    private static final String SUBJECT = "Video API - New video uploaded";
    private static final String TEXT = "New video has been uploaded to the Video API.";

    public void sendMail() {
        log.info("Starting email preparation...");
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(MAIL_ADDRESS);
            mailMessage.setSubject(SUBJECT);
            mailMessage.setText(TEXT);
            javaMailSender.send(mailMessage);
            log.info("Email has been sent.");
        } catch (MailException e) {
            log.error("Failed to process email sending: {} ", e.getMessage(), e);
        }
    }
}
