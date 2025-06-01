package com.example.spring_pattern.order;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

@RequestMapping("/order")
public class OrderApi {

    private final ModelMapper modelMapper;
    private List<OrderDto> orderDtos;

    public OrderApi(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.orderDtos = new ArrayList<>();

        Order order = new Order(new Customer("John Doe", "AE2214"), new Address("Krakowska", "Kraków"));
        Order order2 = new Order(new Customer("Jane Doe","`AE2215"), new Address("Wrocławska", "Wrocław"));
        orderDtos.add(modelMapper.map(order, OrderDto.class));
        orderDtos.add(modelMapper.map(order2, OrderDto.class));
    }



    @GetMapping
    public List<OrderDto> getOrders() {
        return orderDtos;
    }
}
