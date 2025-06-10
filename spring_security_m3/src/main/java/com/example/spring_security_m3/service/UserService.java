package com.example.spring_security_m3.service;

import com.example.spring_security_m3.entity.AppUser;
import com.example.spring_security_m3.entity.VerificationToken;
import com.example.spring_security_m3.repository.AppUserRepo;
import com.example.spring_security_m3.repository.VerificationRepo;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final VerificationRepo verificationRepo;
    private final MailCreatorService mailCreatorService;

    public void addUser(AppUser appUser, HttpServletRequest request) throws MessagingException {
        if (appUserRepo.findByUsername(appUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists: " + appUser.getUsername());
        }
        appUser.setUsername(appUser.getUsername());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, appUser);
        verificationRepo.save(verificationToken);

        String url = "http://" + request.getServerName() + ":"
                + request.getServerPort() +
                request.getContextPath() +
                "/verify-token?token=" + token;

        mailCreatorService.sendMail(appUser.getUsername(),
                "Verification Token",
                "Please click the link to verify your account: " + url,
                false);
    }

    public void verifyToken(String token) {
        AppUser appUser = verificationRepo.findByValue(token).getAppUser();
        appUser.setChangeStatus(true);
        appUserRepo.save(appUser);
    }
}