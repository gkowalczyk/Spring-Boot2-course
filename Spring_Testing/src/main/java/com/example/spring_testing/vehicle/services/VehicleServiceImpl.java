package com.example.spring_testing.vehicle.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.spring_testing.vehicle.entities.Vehicle;
import com.example.spring_testing.vehicle.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    /* @Autowired
    private VehicleRepository vehicleRepository;*/
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.orElseThrow(() -> new EntityNotFoundException("No vehicle with such id: " + id));
    }

    @Override
    public List<Vehicle> findAllVehiclesByColor(String color) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .filter(vehicle -> vehicle.getColor().equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> saveVehicleList(List<Vehicle> vehicleList) {
        Iterable<Vehicle> vehicleIterator = vehicleRepository.saveAll(vehicleList);
        return StreamSupport.stream(vehicleIterator.spliterator(), true).collect(Collectors.toList());
    }
}
