package com.example.spring_pattern.abstract_factory;

import org.springframework.stereotype.Component;

@Component
@TypeFood(foodType = FoodType.FAST_FOOD)
public class FastFoodMeal extends KitchenMeal {
    @Override
    public String getName() {
        return "Fast Food Meal";
    }
}
