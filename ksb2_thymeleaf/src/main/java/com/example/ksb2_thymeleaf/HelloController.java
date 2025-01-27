package com.example.ksb2_thymeleaf;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HelloController {

    private List<Car> cars;

    public HelloController() {

        Car car = new Car("Ford", "Mustang");
        Car car2 = new Car("Chevrolet", "Camaro");
        Car car3 = new Car("Dodge", "Challenger");
        cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/hello2")
    public String sayHello2(Model model) {
        model.addAttribute("message", "Hello from the controller");
        return "hello";
    }

    @GetMapping("/car")
    public String getCar(Model model) {
        Car car = new Car("Ford", "Mustang");
        car.setMark("Ford");
        car.setModel("Mustang");
        model.addAttribute("car", car);
        return "car";
    }

    @GetMapping("/cars")
    public String getCars(Model model) {

        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "cars";

    }

    @GetMapping("/update-car")
    public String showUpdateCarForm(@RequestParam("mark") String mark, @RequestParam("model") String modelCar, Model model) {
        Car carToUpdate = cars.stream()
                .filter(c -> c.getMark().equals(mark) && c.getModel().equals(modelCar))
                .findFirst()
                .orElse(null);
        if (carToUpdate != null) {
            model.addAttribute("carToUpdate", carToUpdate);
        }
        return "update-car";
    }


    @PostMapping("/update-car")
    public String updateCar(@ModelAttribute Car car) {
        cars.stream()
                .filter(c -> c.getMark().equals(car.getMark()) && c.getModel().equals(car.getModel()))
                .findFirst()
                .ifPresent(c -> {
                    c.setMark(car.getMark());
                    c.setModel(car.getModel());
                });
        ;
        return "redirect:/cars";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        return "redirect:/cars";
    }

    @PostMapping("/remove-car")
    public String deleteCar(@ModelAttribute Car car) {
        cars.removeIf(c -> c.getMark().equals(car.getMark()) && c.getModel().equals(car.getModel()));
        return "redirect:/cars";
    }

}
