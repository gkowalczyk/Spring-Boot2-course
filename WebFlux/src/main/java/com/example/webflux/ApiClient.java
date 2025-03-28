package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ApiClient {

    private final Logger logger = LoggerFactory.getLogger(ApiClient.class);

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        Flux<Student> flux = WebClient.create()
                .get()
                .uri("localhost:8081")
                .retrieve()
                .bodyToFlux(Student.class); // json -> Student
        flux.subscribe(student -> logger.info(student.toString()));
    }

   // @EventListener(ApplicationReadyEvent.class)
    public void create() {
        Flux<Student> flux = WebClient.create()
                .post()
                .uri("localhost:8081")
                .body(Mono.just(new Student("Grzegorz")), Student.class)
                .retrieve()
                .bodyToFlux(Student.class); // json -> Student
        flux.subscribe(student -> logger.info(student.toString()));
    }
}
