package com.example.carapiapp.service;

import com.example.carapiapp.domain.Car;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarService {

    private List<Car> carList = new ArrayList<>();

    public CarService() {
        carList.add(new Car(1L, "Toyota", "Corolla", "Red"));
        carList.add(new Car(2L, "Toyota", "Camry", "Red"));
        carList.add(new Car(3L, "Toyota", "RAV4", "Black"));
    }

    public List<Car> getCars() {
        return carList;
    }

    public Optional<Car> getCarById(Long id) {
        return carList.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    public Optional<List<Car>> getCarsByColor(String color) {
        List<Car> cars = carList.stream()
                .filter(car -> car.getColor().equals(color))
                .collect(Collectors.toList());
        return cars.isEmpty() ? Optional.empty() : Optional.of(cars);
    }

    public boolean addCar(@Valid Car car) {
        return carList.add(car);
    }

    public Optional<Car> updateCar(Car newCar) {
        return carList.stream()
                .filter(car -> Objects.equals(car.getId(), newCar.getId()))
                .findFirst()
                .map(car -> {
                    car.setBrand(newCar.getBrand());
                    car.setModel(newCar.getModel());
                    car.setColor(newCar.getColor());
                    return car;
                });
    }

    public Optional<Car> updateFieldCar(Long id, String field, String value) {
        return getCarById(id)
                .map(car -> {
                    switch (field) {
                        case "brand":
                            car.setBrand(value);
                            break;
                        case "model":
                            car.setModel(value);
                            break;
                        case "color":
                            car.setColor(value);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid field: " + field);
                    }
                    return car;
                });
    }

    public boolean deleteCar(Long id) {
        Optional<Car> first = getCarById(id);
        return first.map(car -> carList.remove(car)).orElse(false);
    }
}



