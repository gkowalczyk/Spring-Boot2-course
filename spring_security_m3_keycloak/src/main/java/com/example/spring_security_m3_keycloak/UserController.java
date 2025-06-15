package com.example.spring_security_m3_keycloak;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserController {


    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String forAdmin() {
        return "This is for admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('user')")
    public String foruser() {
        return "This is for user";
    }

    @GetMapping("/token")
    public Object tokenInfo(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getClaims();
    }

    @GetMapping("/debug")
    public Object debug(Authentication auth) {
        System.out.println("👤 Auth: " + auth);
        System.out.println("🔐 Authorities: " + auth.getAuthorities());
        return Map.of(
                "name", auth.getName(),
                "authorities", auth.getAuthorities()
        );
    }
}
