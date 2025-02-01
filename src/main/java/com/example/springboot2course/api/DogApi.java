package com.example.springboot2course.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogApi {

    private List<Dog> dogs = new ArrayList<>();

    public DogApi() {
        dogs.add(new Dog("Burek", "Owczarek"));
        dogs.add(new Dog("Reksio", "Mieszaniec"));
    }

    @GetMapping("/dogs")
    public List<Dog> getDogs(@RequestHeader int index) {
        return dogs.subList(0, index);
    }

    @PostMapping("/dogs")
    public void addDog(@RequestBody Dog dog) {
        dogs.add(dog);
    }
}
