package com.example.spring_testing.api_car;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalController {
    private final AnimalRepo animalRepo;

    public AnimalController(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animalRepo.findAll().iterator().forEachRemaining(animals::add);
        return animals;
    }

    public Animal addAnimal(Animal animal) {
        return animalRepo.save(animal);
    }


}
