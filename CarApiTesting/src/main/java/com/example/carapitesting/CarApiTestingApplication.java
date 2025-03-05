package com.example.carapitesting;

import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.repositories.VehicleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarApiTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApiTestingApplication.class, args);
    }

    private final VehicleRepository vehicleRepository;

    public CarApiTestingApplication(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        vehicleRepository.save(new Vehicle("Toyota", "Corolla", "Red"));
        vehicleRepository.save(new Vehicle("Toyota", "Camry", "Blue"));
        vehicleRepository.save(new Vehicle("Toyota", "RAV4", "Black"));
        vehicleRepository.save(new Vehicle("Toyota", "Highlander", "White"));
        vehicleRepository.save(new Vehicle("Toyota", "Highlander", "White"));
    }


}
