package com.example.carapiapp.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Car{

    @NotNull(message = "Id is required")
    @Min(value = 0, message = "Id should be greater than 0")
    @Max(value = Long.MAX_VALUE, message = "Id should be less than " + Long.MAX_VALUE)
    private Long id;
    private String brand;
    private String model;
    private String color;

}
