package com.example.springboot2course.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalPrice() {
        return ResponseEntity.ok(shopService.getTotalPrice());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProductToCart(@RequestBody Product product) {
        if (shopService.addProductToCart(product)) {
            return ResponseEntity.ok("Product added to cart");
        } else {
            return ResponseEntity.badRequest().body("Product not added to cart");
        }
    }
}
