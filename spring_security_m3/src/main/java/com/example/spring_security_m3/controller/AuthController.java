package com.example.spring_security_m3.controller;

import com.example.spring_security_m3.entity.AppUser;
import com.example.spring_security_m3.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AppUser appUser, HttpServletRequest request) throws MessagingException {
        userService.addUser(appUser, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify-token")
    public ResponseEntity<Void> register(@RequestParam String token) {
        userService.verifyToken(token);
        return ResponseEntity.ok().build();
    }
}
