package com.example.springaopapp;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class Hello {

    @EventListener(ApplicationStartedEvent.class)
    @HelloAspectAnnot
    public void sayHello() {
        System.out.println("Hello");
    }

    @Schedules({
            @Scheduled(fixedDelay = 1000),
            @Scheduled(cron = "0 0 0 * * ?")
    })
    public void schedule() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Scheduled task");

    }
}
