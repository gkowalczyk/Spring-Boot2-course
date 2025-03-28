package com.example.spring_pattern.builder;

public class CarBuilder {
    private String wheel;
    private String color;

    public CarBuilder setWheel(String wheel) {
        this.wheel = wheel;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Car createCar() {
        return new Car(wheel, color);
    }
}