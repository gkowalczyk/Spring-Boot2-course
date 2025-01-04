package com.example.springboot2course.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("start")
@Slf4j
public class ShopServiceStart extends ShopService {

    public ShopServiceStart(ProductGenerator productGenerator) {
        super(productGenerator);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        log.info("Total price: " + super.getTotalPrice());
        products.forEach(product -> log.info(product.toString()));
    }
}
