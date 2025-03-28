package com.example.webflux;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {

    private StudentRepo studentRepo;

    public InitService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
       
        studentRepo.deleteAll()
                .thenMany(
                        Flux.just("Adam", "Ania", "Karol"))
                .map(Student::new)
               // .map(studentRepo::save)
               .flatMap(studentRepo::save)
                //.thenMany(studentRepo.findAll());
                .subscribe();
    }

}
