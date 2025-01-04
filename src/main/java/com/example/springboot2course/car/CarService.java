package com.example.springboot2course.car;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("Toyota", "Corolla"));
        cars.add(new Car("Toyota", "Camry"));
        cars.add(new Car("Toyota", "Rav4"));
        cars.add(new Car("Toyota", "Highlander"));
        cars.add(new Car("Toyota", "4Runner"));
        cars.add(new Car("Toyota", "Tacoma"));
        cars.add(new Car("Toyota", "Tundra"));
        cars.add(new Car("Toyota", "Sienna"));
        cars.add(new Car("Toyota", "Sequoia"));
        cars.add(new Car("Toyota", "Land Cruiser"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showCars() {
        cars.forEach(System.out::println);
    }

    public List<Car> getCars() {
        return cars;
    }
}
