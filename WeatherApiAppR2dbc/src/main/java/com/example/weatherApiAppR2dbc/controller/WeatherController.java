package com.example.weatherApiAppR2dbc.controller;

import com.example.weatherApiAppR2dbc.modelDto.WeatherCardDto;
import com.example.weatherApiAppR2dbc.service.CityHolder;
import com.example.weatherApiAppR2dbc.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final CityHolder cityHolder;

    @GetMapping
    public ResponseEntity<Mono<WeatherCardDto>> getWeather(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }

    @PostMapping("/set-newCity")
    public ResponseEntity<String> setCity(@RequestParam String city) {
        cityHolder.setCity(city);
        return ResponseEntity.ok("Miasto zmienione na:" + city);
    }
}
