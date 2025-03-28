package com.example.spring_pattern.abstract_factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("IceCreamMeal")
@TypeFood(foodType = FoodType.ICE_CREAM)
public class IceCreamMeal extends KitchenMeal {
    @Override
    public String getName() {
        return "Ice Cream Meal";
    }
}
