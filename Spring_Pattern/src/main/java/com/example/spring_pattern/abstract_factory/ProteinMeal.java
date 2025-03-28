package com.example.spring_pattern.abstract_factory;

import org.springframework.stereotype.Component;

@Component
@TypeFood(foodType = FoodType.PROTEIN)
public class ProteinMeal extends KitchenMeal {
    @Override
    public String getName() {
        return "Protein Meal";
    }
}
