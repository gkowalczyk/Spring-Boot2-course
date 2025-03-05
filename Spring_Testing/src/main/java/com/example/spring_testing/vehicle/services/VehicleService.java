package com.example.spring_testing.vehicle.services;


import com.example.spring_testing.vehicle.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAllVehicles();

    Vehicle findVehicleById(Long id);

    List<Vehicle> findAllVehiclesByColor(String color);

    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle>  saveVehicleList(List<Vehicle> vehicleList);

}
