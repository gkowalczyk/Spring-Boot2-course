package com.example.springboot2course.shop;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class ShopService {

    protected List<Product> products = new ArrayList<>();
    private ProductGenerator productGenerator;

    @Autowired
    public ShopService(ProductGenerator productGenerator) {
        this.productGenerator = productGenerator;
        products = productGenerator.generateProduct(5);

    }
    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::price)
                .sum();
    }
}
