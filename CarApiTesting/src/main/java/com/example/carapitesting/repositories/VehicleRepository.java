package com.example.carapitesting.repositories;


import com.example.carapitesting.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Iterable<Vehicle> findAllByColor(String color);
}
