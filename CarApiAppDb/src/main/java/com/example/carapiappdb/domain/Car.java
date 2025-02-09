package com.example.carapiappdb.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Car{

    @NotNull(message = "Id is required")
    @Min(value = 0, message = "Id should be greater than 0")
    @Max(value = Long.MAX_VALUE, message = "Id should be less than " + Long.MAX_VALUE)
    private Long id;
    private String brand;
    private String model;
    private String color;
    private LocalDate dateProduced;

    public Car(String brand, String model, String color, LocalDate dateProduced) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.dateProduced = dateProduced;
    }
}
