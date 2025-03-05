package com.example.spring_testing;

import com.example.spring_testing.api_car.Animal;
import com.example.spring_testing.api_car.AnimalRepo;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringTestingApplication {

    @Autowired
    private AnimalRepo animalRepo;

    @EventListener(ApplicationEvent.class)
    public void init() {

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTestingApplication.class, args);
    }


}
