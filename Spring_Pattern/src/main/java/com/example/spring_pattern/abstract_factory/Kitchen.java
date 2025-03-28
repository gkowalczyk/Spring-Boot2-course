package com.example.spring_pattern.abstract_factory;

import org.springframework.stereotype.Component;

@Component
public abstract class Kitchen {
    public abstract KitchenMeal getMeal(FoodType foodType);

    public abstract KitchenMeal getDessert(FoodType foodType);
}
