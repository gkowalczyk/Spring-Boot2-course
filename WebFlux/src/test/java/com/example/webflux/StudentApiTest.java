package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class StudentApiTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void get() {
        webTestClient.get()
                .uri("localhost:8081")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .hasSize(3);
    }
    @Test
    void getStudentBySurname() {
        webTestClient.get()
                .uri("localhost:8081/{surname}", "Adam")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class)
                .value(student -> assertEquals("Adam", student.getName()));

    }

    @Test
    void create() {

        webTestClient
                    .post()
                    .uri("localhost:8081")
                    .body(Mono.just(new Student("Grzegorz")), Student.class)
                    .exchange()
                    .expectStatus().isOk();
    }

    @Test
    void getById() {
    }
}