package com.example.carapiappdb.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Car{

    private Long id;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @NotBlank(message = "Model is mandatory")
    private String model;
    @NotBlank(message = "Color is mandatory")
    private String color;
    @NotNull(message = "Date produced is mandatory")
    private LocalDate dateProduced;

    public Car(String brand, String model, String color, LocalDate dateProduced) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.dateProduced = dateProduced;
    }
}
