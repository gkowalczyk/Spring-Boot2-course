package com.example.spring_testing.api_car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private final AnimalController animalController;

    public Api(AnimalController animalController) {
        this.animalController = animalController;
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animalController.getAnimals();
    }

    @PostMapping("/add")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalController.addAnimal(animal);
    }
}
