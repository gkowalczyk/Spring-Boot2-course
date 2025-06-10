package com.example.spring_security_m3;

import com.example.spring_security_m3.entity.AppUser;
import com.example.spring_security_m3.repository.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private PasswordEncoder passwordEncoder;
    private AppUserRepo appUserRepo;

    public Start(PasswordEncoder passwordEncoder, AppUserRepo appUserRepo) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;

        AppUser appUser = new AppUser();
        appUser.setUsername("Grzegorz");
        appUser.setChangeStatus(true);
        appUser.setPassword(passwordEncoder.encode("password"));
        appUserRepo.save(appUser);
    }
}
