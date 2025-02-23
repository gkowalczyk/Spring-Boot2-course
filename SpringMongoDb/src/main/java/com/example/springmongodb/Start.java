package com.example.springmongodb;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Start {

    private final ToyRepository toyRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Toy toy = new Toy("1", "Barbie", ToyType.DOLL);
        Toy toy2 = new Toy("2", "GI Joe", ToyType.ACTION_FIGURE);
       // toyRepository.save(toy);
       // toyRepository.save(toy2);

        System.out.println(toyRepository.findById("1").get());
        toyRepository.findAll().forEach(System.out::println);
        toy.setType(ToyType.ACTION_FIGURE);
        toyRepository.save(toy);
        toyRepository.findAll().forEach(System.out::println);
        toyRepository.deleteById("1");
        toyRepository.delete(toy2);
    }
}
