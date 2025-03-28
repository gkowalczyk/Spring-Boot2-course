package com.example.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class StudentApi {

    private StudentRepo studentRepo;

    public StudentApi(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

   /* @GetMapping
    public Flux<String> get() {
        return Flux.just("Adam", "Ania", "Karol");
    }*/
     @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
       return studentRepo.findAll().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> create(@RequestBody Student student) {
        return studentRepo.save(student).thenMany(studentRepo.findAll());
    }

    @GetMapping(value = "/{surname}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Student> getById(@PathVariable String surname) {
        return studentRepo.findStudentByName(surname);
    }

}
