package com.example.carapitesting.services;

import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final GenerateRandomColor generateRandomColor;

    public List<Vehicle> findAllVehicles() {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .collect(Collectors.toList());
    }

    public Vehicle findVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.orElseThrow(() -> new EntityNotFoundException("No vehicle with such id: " + id));
    }

    public List<Vehicle> findAllVehiclesByColor(String color) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .filter(vehicle -> vehicle.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findAllVehiclesByColorAndChangeColor(String findColor) {
        String colorToChange = generateRandomColor.generateRandomColor();
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        return StreamSupport.stream(vehicles.spliterator(), true)
                .filter(vehicle -> vehicle.getColor().equals(findColor))
                .peek(vehicle -> vehicle.setColor(colorToChange))
                .map(vehicleRepository::save)
                .collect(Collectors.toList());
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> saveVehicleList(List<Vehicle> vehicleList) {
        Iterable<Vehicle> vehicleIterator = vehicleRepository.saveAll(vehicleList);
        return StreamSupport.stream(vehicleIterator.spliterator(), true)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No vehicle with such id: " + id));
        vehicleRepository.delete(vehicle);
    }
}
