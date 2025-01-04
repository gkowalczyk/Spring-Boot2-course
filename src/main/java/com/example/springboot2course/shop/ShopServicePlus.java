package com.example.springboot2course.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
@Profile("plus")
@Slf4j
public class ShopServicePlus extends ShopService {

    @Value("${price-data.tax}")
    private double tax;

    public ShopServicePlus(ProductGenerator productGenerator) {
        super(productGenerator);
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() * tax;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        log.info("Total price with tax: {}", getTotalPrice());
        products.forEach(product -> log.info(product.toString()));
    }
}
