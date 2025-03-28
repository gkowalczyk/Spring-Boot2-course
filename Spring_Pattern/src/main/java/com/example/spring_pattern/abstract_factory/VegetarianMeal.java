package com.example.spring_pattern.abstract_factory;

import org.springframework.stereotype.Component;

@Component
public class VegetarianMeal extends KitchenMeal {
    @Override
    public String getName() {
        return "Vegetarian Meal";
    }
}
