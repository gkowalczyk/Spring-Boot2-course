package com.example.spring_security_jwtv2;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}
