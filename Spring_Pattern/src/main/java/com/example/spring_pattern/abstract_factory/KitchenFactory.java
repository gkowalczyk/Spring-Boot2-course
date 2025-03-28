package com.example.spring_pattern.abstract_factory;

public class KitchenFactory extends Kitchen {

    @Override
    public KitchenMeal getMeal(FoodType foodType) {
        if (foodType == FoodType.FAST_FOOD) {
            return new FastFoodMeal();
        } else if (foodType == FoodType.PROTEIN) {
            return new ProteinMeal();
        }
        return new VegetarianMeal();
    }

    @Override
    public KitchenMeal getDessert(FoodType foodType) {
        if (foodType == FoodType.ICE_CREAM) {
            return new IceCreamMeal();
        }
        return null;
    }
}
