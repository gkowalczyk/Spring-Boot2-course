package com.example.spring_security_m3.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
@Component
public class LoginCounterHandler implements AuthenticationSuccessHandler {

    private final ConcurrentHashMap<String, Integer> loginCounter = new ConcurrentHashMap<>();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String username = authentication.getName();
        loginCounter.merge(username, 1, Integer::sum);
        log.info("User {} has logged in {} times", username, loginCounter.get(username));
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
