package com.example.springboot2course.car;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CardServiceMain {

    private final Card card;

    public CardServiceMain(@Qualifier("visaService") Card card) { //Qualifiers are used to resolve the ambiguity when you have multiple beans of the same type.
        this.card = card;
        String info = card.getInformation();
        System.out.println(info);
    }
}
