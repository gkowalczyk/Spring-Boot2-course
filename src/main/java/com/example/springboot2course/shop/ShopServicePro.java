package com.example.springboot2course.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("pro")
public class ShopServicePro extends ShopService {

    @Value("${price-data.tax}")
    private double tax;

    @Value("${price-data.discount}")
    private double discount;

    public ShopServicePro(ProductGenerator productGenerator) {
        super(productGenerator);
    }

    @Override
    public double getTotalPrice() {
        return (super.getTotalPrice() * tax) * 1 - discount;

    }
    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        log.info("Total price with tax and discount: {}", getTotalPrice());
        products.forEach(product -> log.info(product.toString()));
    }
}
