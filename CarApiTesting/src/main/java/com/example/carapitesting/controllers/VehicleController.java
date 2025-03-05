package com.example.carapitesting.controllers;

import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/vehicles")
@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.findAllVehicles();
    }

    @GetMapping(value = "/filter")
    public List<Vehicle> getVehiclesByColor(@RequestParam String color) {
        return vehicleService.findAllVehiclesByColor(color);
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.findVehicleById(id);
    }

    @PostMapping
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping(value = "/save-all")
    public List<Vehicle> saveVehicleList(@RequestBody List<Vehicle> vehicleList) {
        return vehicleService.saveVehicleList(vehicleList);
    }

    @PutMapping(value = "/filter-and-change-color")
    public List<Vehicle> getVehiclesByColorAndRandomChangeColor(@RequestParam String color) {
        return vehicleService.findAllVehiclesByColorAndChangeColor(color);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVehicleById(@PathVariable Long id) {
        vehicleService.deleteById(id);
    }
}
