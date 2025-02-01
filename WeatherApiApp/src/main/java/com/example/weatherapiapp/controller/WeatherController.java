package com.example.weatherapiapp.controller;

import com.example.weatherapiapp.client.WeatherClient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Data
@CrossOrigin("*")
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherClient weatherClient;

    @GetMapping
    public ResponseEntity<Mono<String>> getWeather(@RequestParam String city) {
        return ResponseEntity.ok(weatherClient.getWeather(city));
    }
}
