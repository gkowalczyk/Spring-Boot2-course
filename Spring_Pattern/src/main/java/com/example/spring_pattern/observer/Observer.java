package com.example.spring_pattern.observer;

import org.springframework.stereotype.Component;

@Component
public class Observer implements Observable{

    public Observer()  {
       new Task(this);
    }

    @Override
    public void notify(String message) {
        System.out.println(" received message: " + message);
    }
}
