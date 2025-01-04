package com.example.springboot2course.car;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {

    private MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
        String text = messageSource.getMessage("hello", new Object[]{"g", "k"}, "Default message", Locale.ENGLISH);
        String text1 = messageSource.getMessage("hello", new Object[]{"g" , "k"}, "Default message", Locale.forLanguageTag("pl"));
        System.out.println(text);
        System.out.println(text1);
    }

}
