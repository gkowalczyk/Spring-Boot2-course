package com.example.weatherApiAppR2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
class WeatherApiAppR2dbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiAppR2dbcApplication.class, args);
    }

}
