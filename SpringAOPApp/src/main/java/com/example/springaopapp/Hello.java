package com.example.springaopapp;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Hello {

    @EventListener(ApplicationStartedEvent.class)
    @HelloAspectAnnot
    public void sayHello() {
        System.out.println("Hello");
    }
}
