package com.example.spring_pattern;

import com.example.spring_pattern.order.Order;
import com.example.spring_pattern.order.OrderDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SpringPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPatternApplication.class, args);
    }
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Order, OrderDto>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity());
                map().setStreet(source.getAddress().getStreet());
                map().setName(source.getCustomer().getName());
                map().setDate(LocalDate.now());
            }
        });
        return modelMapper;
    }
}
