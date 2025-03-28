package com.example.spring_pattern.builder;

public class Car {

    private final String wheel;
    private final String color;

    public Car(String wheel, String color) {
        this.wheel = wheel;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheel='" + wheel + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
