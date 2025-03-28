package com.example.spring_pattern.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Customer {

    private final String name;
    @JsonIgnore
    private final String idCard;
}
