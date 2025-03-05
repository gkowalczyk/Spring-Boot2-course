package com.example.spring_testing.api_car;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
