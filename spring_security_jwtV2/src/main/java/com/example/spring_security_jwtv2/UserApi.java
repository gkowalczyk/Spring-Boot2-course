package com.example.spring_security_jwtv2;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApi {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public ResponseEntity<?> get(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            User principal = (User) authentication.getPrincipal();
            System.out.println(principal);

            Algorithm algorithm = Algorithm.HMAC256("secret"); // to move application.properties
            String token = JWT.create()
                    .withSubject(principal.getUsername())
                    .withIssuer("Emitent")
                    .withClaim("roles",
                            List.of("ROLE_" + principal.getRole()))
                    .sign(algorithm);
            AuthResponse authResponse = new AuthResponse(principal.getUsername(), token);
            return ResponseEntity.ok(authResponse);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
