package com.example.spring_pattern.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Address {

    private final String street;
    private final String city;
}
