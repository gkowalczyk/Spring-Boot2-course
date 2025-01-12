package com.example.carapiapp.controller;

import com.example.carapiapp.domain.Car;
import com.example.carapiapp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<EntityModel<Car>>> getCars() {
        List<EntityModel<Car>> cars = carService.getCars().stream()
                .map(car -> {
                    EntityModel<Car> carResource = EntityModel.of(car);
                    carResource.add(WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(CarController.class)
                                    .getCarById(car.getId())).withSelfRel());
                    return carResource;
                })
                .collect(Collectors.toList());
        CollectionModel<EntityModel<Car>> collectionModel = CollectionModel.of(cars);
        collectionModel.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(CarController.class).getCars()).withSelfRel());
        return ResponseEntity.ok(collectionModel);
    }


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable Long id) {
        return carService.getCarById(id)
                .map(car -> {
                    EntityModel<Car> carEntityModel = EntityModel.of(car);
                    carEntityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                            .methodOn(this.getClass()).getCars()).withRel("all-cars"));
                    carEntityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                            .methodOn(this.getClass()).getCarById(id)).withSelfRel());
                    return ResponseEntity.ok(carEntityModel);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/findByColors", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Car>> getCarByColor(@RequestParam(required = false) String color) {
        return carService.getCarsByColor(color)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@Validated @RequestBody Car car) {
        return carService.addCar(car) ? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@Validated @RequestBody Car newCar) {
        return carService.updateCar(newCar)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updateOneFieldCar(@PathVariable Long id,
                                                 @RequestParam String field,
                                                 @RequestParam String value) {
        try {
            return carService.updateFieldCar(id, field, value)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable Long id) {
        return carService.deleteCar(id) ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

