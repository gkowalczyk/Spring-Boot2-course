package com.example.carapitesting.controllers;

import com.example.carapitesting.entities.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class VehicleControllerE2eTest {

    @BeforeEach
    void setUp() {
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Red");
        testRestTemplate.postForObject("http://localhost:" + port + "/api/vehicles", vehicle, Vehicle.class);
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnElementsByColor() {
        ResponseEntity<Vehicle[]> actual = testRestTemplate.exchange("http://localhost:" + port + "/api/vehicles/filter?color=Red",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Vehicle[].class);
        Assertions.assertEquals("Toyota", Objects.requireNonNull(actual.getBody())[0].getBrand());
    }
}

