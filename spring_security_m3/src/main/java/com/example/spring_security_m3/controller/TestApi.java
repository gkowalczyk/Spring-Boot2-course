package com.example.spring_security_m3.controller;

import com.example.spring_security_m3.service.LoginCounterHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestApi {

    private final LoginCounterHandler loginCounterHandler;

    @GetMapping("anonymous")
    public String forAll() {
        return "This is for guest";
    }

    @GetMapping("user")
    public String forUser(Principal principal) {
        int loginCount = getLoginCounter(principal);
        return "This is for user:" + principal.getName() +
                ". You have logged in " + loginCount + " times.";
    }

    @GetMapping("admin")
    public String forAdmin(Principal principal) {
        int loginCount = getLoginCounter(principal);
        return "This is for admin:" + principal.getName() +
                ". You have logged in " + loginCount + " times.";
    }

    @GetMapping("bye")
    public String logOut() {
        return "Bye! You have been logged out.";
    }

    private int getLoginCounter(Principal principal) {
        return loginCounterHandler.getLoginCounter()
                .getOrDefault(principal.getName(), 0);
    }

}
