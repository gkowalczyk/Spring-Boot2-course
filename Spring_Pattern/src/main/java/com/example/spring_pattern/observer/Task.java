package com.example.spring_pattern.observer;

import java.util.Random;

public class Task {

    public Task(Observable observable) {

        while (true) {
            int timeDelay = new Random().nextInt(5000) + 1000;
            try {
                Thread.sleep(timeDelay);
                observable.notify("Task completed in " + timeDelay + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}