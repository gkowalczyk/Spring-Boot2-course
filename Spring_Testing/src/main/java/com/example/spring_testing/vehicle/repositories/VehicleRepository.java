package com.example.spring_testing.vehicle.repositories;

import com.example.spring_testing.vehicle.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Iterable<Vehicle> findAllByColor(String color);
}
