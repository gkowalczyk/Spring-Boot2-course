package com.example.spring_security_jwtv2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String get() {
        System.out.println("hello");
        return "hello";
    }
}
