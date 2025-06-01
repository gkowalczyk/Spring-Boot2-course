package com.example.spring_pattern.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Order {

    private final Customer customer;
    private final Address address;
}


