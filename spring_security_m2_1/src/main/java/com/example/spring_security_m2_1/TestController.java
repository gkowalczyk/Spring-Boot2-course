package com.example.spring_security_m2_1;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("forAll")
    public String forAll() {
        return "This is for all users";
    }

    @GetMapping("user")
    public String forUser() {
        return "This is for user";
    }

    @GetMapping("admin")
    public String forAdmin(Principal principal) {
        return "Hello admin " + ((OAuth2AuthenticationToken) principal).getPrincipal().getAttributes().get("name");
    }

    @GetMapping("/login")
    public String login() {
        return "Login page (default Spring Security form)";
    }
}