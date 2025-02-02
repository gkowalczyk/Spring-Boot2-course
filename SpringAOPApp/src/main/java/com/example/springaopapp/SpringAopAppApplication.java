package com.example.springaopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class SpringAopAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopAppApplication.class, args);
    }

}
