package com.example.spring_testing.people;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController("peopleApi")
public class Api {

    private List<People> people;

    public Api() {
        people = new ArrayList<>();
        people.add(new People("John", "Daniels", Sex.FEMALE));
        people.add(new People("Jane", "Mae", Sex.MALE));

    }
    @GetMapping("/people/{limit}")
    public List<People> getPeople(@PathVariable("limit") int limit) {
        return people.subList(0, limit);
    }
    @GetMapping("/people")
    public String hello() {
        return "Hello";
    }
}
