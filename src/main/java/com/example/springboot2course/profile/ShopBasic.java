package com.example.springboot2course.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("basic")
public class ShopBasic {

    public ShopBasic() {
        System.out.println("ShopBasic");
    }
}
