package com.example.spring_testing.api_car;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AnimalSorter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String[] sortAnimals() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> exchange = restTemplate.exchange("http://localhost:8082/animals",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String[].class);

        return exchange.getBody();
    }

    public String[] sortData() throws JsonProcessingException {
        String[] data = sortAnimals();
        Arrays.sort(data);
        Arrays.stream(data).forEach(System.out::println);
        return data;
    }
}
