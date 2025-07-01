package com.example.spring_security_m3_hom;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody AppUser appUser, HttpServletRequest request) throws MessagingException {

        userService.addUser(appUser, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify-token")
    public ResponseEntity<Void> verifyToken(@RequestParam String token) {
        userService.verifyToken(token);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verifyAdmin-token")
    public ResponseEntity<Void> verifyAdminToken(@RequestParam String token) {
        userService.verifyAdminToken(token);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public String forUser(Principal principal) {
        return "This is for user:" + principal.getName();
    }

    @GetMapping("/admin")
    public String forAdmin(Principal principal) {
        return "This is for admin:" + principal.getName();
    }

    @GetMapping("/admin/data")
    public String getAdminDataForTestingHttpMethod() {
        return "This is admin data";
    }

    @PostMapping("/admin/data")
    public void saveAdminDataForTestingHttpMethod() {
        System.out.println("Admin data saved");
    }
}


