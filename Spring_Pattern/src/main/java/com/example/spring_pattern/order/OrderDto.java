package com.example.spring_pattern.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@RequiredArgsConstructor
@Data
public class OrderDto {

    private String street;
    private String city;
    private String name;
    private LocalDate date;
}
