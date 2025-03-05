package com.example.spring_testing.vehicle.controllers;

import com.example.spring_testing.vehicle.entities.Vehicle;
import com.example.spring_testing.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/vehicles")
@RestController
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles(){
        return vehicleService.findAllVehicles();
    }

    @GetMapping(value = "/filter")
    public List<Vehicle> getVehiclesByColor(@RequestParam String color){
        return vehicleService.findAllVehiclesByColor(color);
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable Long id){
        return vehicleService.findVehicleById(id);
    }

    @PostMapping
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    public @PostMapping(value = "/save-all")
    List<Vehicle> saveVehicleList(@RequestBody List<Vehicle> vehicleList){
        return vehicleService.saveVehicleList(vehicleList);
    }

}
