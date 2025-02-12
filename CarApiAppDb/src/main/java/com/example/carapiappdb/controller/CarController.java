package com.example.carapiappdb.controller;

import com.example.carapiappdb.aspect.SaveNewsToDb;
import com.example.carapiappdb.client.CarNewsClient;
import com.example.carapiappdb.domain.Car;
import com.example.carapiappdb.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    private final CarService carService;
    private final CarNewsClient carNewsClient;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Car>> getCars(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
                                             @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo) {
        return ResponseEntity.ok(carService.findAll(dateFrom, dateTo));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(savedCar));
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetMapping("/news")
    @SaveNewsToDb
    public ResponseEntity<Mono<List<String>>> getCarsNews() {
        return ResponseEntity.ok(carNewsClient.getCarNews());
    }

    @PutMapping
    public ResponseEntity<?> updateNews(@RequestParam("id") Long id, @RequestParam("description") String description) {
        carService.updateNews(id, description);
        return ResponseEntity.ok("Update successful");
    }

    @GetMapping("/news/db")
    public ResponseEntity<List<Map<String, Object>>> getCarsNewsFromDb() {
        return ResponseEntity.ok(carService.getNewsFromDb());
    }
}

