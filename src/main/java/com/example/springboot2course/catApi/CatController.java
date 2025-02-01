package com.example.springboot2course.catApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CatController {

    public CatController() {
        RestTemplate restTemplate = new RestTemplate();

        AnimalFact[] forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", AnimalFact[].class);
        System.out.println(forObject);
    }
}
