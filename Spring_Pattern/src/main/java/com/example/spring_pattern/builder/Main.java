package com.example.spring_pattern.builder;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .setColor("red")
                .setWheel("4")
                .createCar();
        System.out.println(car);
    }
}
