package com.example.spring_security_m3_hom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final VerificationRepo verificationRepo;
    private final MailCreatorService mailCreatorService;
    private final static String ADMIN_EMAIL = "";

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

        String url = "https://" + request.getServerName() + ":"
                + request.getServerPort() +
                request.getContextPath() +
                "/verify-token?token=" + token;

        mailCreatorService.sendMail(appUser.getUsername(),
                "Verification Token",
                "Please click the link to verify your account: " + url,
                false);

        if (appUser.getRequestedRole().equals(Role.ADMIN)) {
            String adminToken = UUID.randomUUID().toString();
            VerificationToken verificationTokenForAdmin = new VerificationToken(adminToken, appUser);
            verificationRepo.save(verificationTokenForAdmin);

            String urlAdmin = "https://" + request.getServerName() + ":"
                    + request.getServerPort() +
                    request.getContextPath() +
                    "/verifyAdmin-token?token=" + adminToken;
            mailCreatorService.sendMail(ADMIN_EMAIL,
                    "Admin Verification Token",
                    "Please click the link to verify your admin account: " + urlAdmin,
                    false);
        }
    }

    public void verifyToken(String token) {
        AppUser appUser = verificationRepo.findByValue(token).getAppUser();
        appUser.setUserPermissionApproval(true);
        appUserRepo.save(appUser);
    }

    public void verifyAdminToken(String token) {
        AppUser appUser = verificationRepo.findByValue(token).getAppUser();
        appUser.setGrantedRole(Role.ADMIN);
        appUserRepo.save(appUser);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void removeExpiredTokens() {

        List<VerificationToken> list = verificationRepo.findAll()
                .stream()
                .filter(user -> user.getLocalDateTime().isBefore(LocalDateTime.now().minusDays(1)))
                .collect(Collectors.toList());
        verificationRepo.deleteAll(list);

    }
}

