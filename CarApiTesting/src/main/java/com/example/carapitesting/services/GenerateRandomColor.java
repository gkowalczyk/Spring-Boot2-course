package com.example.carapitesting.services;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;

@Component
public class GenerateRandomColor {

    public String generateRandomColor() {
        Random randomColor = new Random();
        List<String> colors = List.of("red", "blue", "green", "yellow", "black", "white", "orange", "purple", "pink", "brown");
        return colors.get(randomColor.nextInt(colors.size()));
    }
}
