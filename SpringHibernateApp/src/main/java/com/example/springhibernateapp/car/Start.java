package com.example.springhibernateapp.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private final CarRepository carRepository;

    @Autowired
    public Start(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        Car car = new Car("BMW", "X5", Color.RED);
        Car car1 = new Car("Audi", "A8", Color.GREEN);
        carRepository.save(car);
        carRepository.save(car1);

        carRepository.findAll().forEach(System.out::println);

        carRepository.findCarsByColor(Color.RED).forEach(System.out::println);

        carRepository.findCarsByColorAndMark(Color.RED, "BMW").forEach(System.out::println);
        System.out.println("My impl");
        carRepository.findCarsByModelMyImpl("X5").forEach(System.out::println);
    }
}
