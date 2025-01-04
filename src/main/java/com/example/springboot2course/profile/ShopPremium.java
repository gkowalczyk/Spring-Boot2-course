package com.example.springboot2course.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("premium")
public class ShopPremium {

    Logger logger = LoggerFactory.getLogger(ShopPremium.class);
    public ShopPremium() {
        System.out.println("ShopPremium óźćżąśłęń");
        logger.warn("ShopPremium");
    }
}
