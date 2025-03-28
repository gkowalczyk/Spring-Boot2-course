package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class WebFluxApplicationTests {

    @Test
    void contextLoads() {
        Flux.just("A", "B", "C")
                .filter(name -> name.startsWith("A"))
                .subscribe(System.out::println);


        Mono.just("A")
                .map(String::toUpperCase)
                .map(s -> s + "B")
                .subscribe(System.out::println);// soat jest blokujące, mozna użyć log
    }

}
