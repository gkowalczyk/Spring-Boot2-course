package com.example.springboot2course.api;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Controller
public class DogClient {

    RestTemplate restTemplate = new RestTemplate();

    public DogClient() {
        this.restTemplate = restTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void getDogs() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("index", "2");
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Dog[]> exchange = restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.GET,
                entity,
                Dog[].class);

        Stream.of(exchange.getBody()).forEach(System.out::println);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void addDog() {
        Dog dog = new Dog("Burek", "Owczarek");
        HttpEntity<Dog> request = new HttpEntity<>(dog);

        restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.POST,
                request,
                Void.class);
    }
}
