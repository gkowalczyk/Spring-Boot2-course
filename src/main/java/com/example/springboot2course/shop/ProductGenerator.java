package com.example.springboot2course.shop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class ProductGenerator {

    private Random random = new Random();
    List<Product> products = new ArrayList<>();

    public List<Product> generateProduct(int count) {

        Stream.generate(() -> new Product("Product" + random.nextInt(50), random.nextDouble(50, 300)))
                .limit(count)
                .forEach(products::add);
        return products;
    }
}
