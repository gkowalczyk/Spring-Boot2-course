package com.example.ksb2_vaadin.manager;

import com.example.ksb2_vaadin.model.Car;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class CarManager {

    private List<Car> carList = new ArrayList<>();

    public CarManager() {
        carList.add(new Car("Ford", "Focus"));
        carList.add(new Car("Opel", "Astra"));
        carList.add(new Car("Toyota", "Corolla"));
    }

    public void addCar(Car car) {
        carList.add(car);
    }


}
