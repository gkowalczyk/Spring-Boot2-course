package com.example.spring_pattern.abstract_factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Restaurant {

    @Autowired
    public Restaurant(@TypeFood(foodType = FoodType.FAST_FOOD) KitchenMeal meal) {
        System.out.println(meal.getName());

   /* 2. Z samym Qualifier
   @Autowired
        public Restaurant(@Qualifier("IceCreamMeal") KitchenMeal meal) {
        System.out.println(meal.getName());*/


       /* 1. bez spring
        Kitchen factory = new KitchenFactory();
        KitchenMeal meal = factory.getMeal(FoodType.VEGETARIAN);
        System.out.println(meal.getName());

        KitchenMeal dessert = factory.getDessert(FoodType.ICE_CREAM);
        System.out.println(dessert.getName());*/

    }
}

