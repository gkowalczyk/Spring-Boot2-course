package com.example.carapitesting.controllers;

import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.repositories.VehicleRepository;
import com.example.carapitesting.services.GenerateRandomColor;
import com.example.carapitesting.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleControllerTestSpy {

    @Mock
    private VehicleRepository vehicleRepository;

    @Spy
    private GenerateRandomColor generateRandomColor;

    @InjectMocks
    private VehicleService vehicleService;


    @ParameterizedTest
    @ValueSource(strings = {"Red", "Blue", "Green", "Blue"})
    public void testFindAllVehiclesByColorAndChangeColor(String color) {

        //Given
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle(1L, "Toyota", "Corolla", color),
                new Vehicle(2L, "Toyota", "Corolla", color)

        );
        when(vehicleRepository.findAll()).thenReturn(vehicles);
        doReturn("Blue").when(generateRandomColor).generateRandomColor();
        when(vehicleRepository.save(any(Vehicle.class))).thenAnswer(answer -> answer.getArgument(0));
        //When
        List<Vehicle> result = vehicleService.findAllVehiclesByColorAndChangeColor(color);
       //Then
        assertEquals(2, result.size());
        assertEquals("Blue", result.get(0).getColor());
        assertEquals("Blue", result.get(1).getColor());
        verify(vehicleRepository, times(2)).save(any(Vehicle.class));
    }
}
