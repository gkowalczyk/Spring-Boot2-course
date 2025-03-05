package com.example.carapitesting.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.services.VehicleService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VehicleControllerUnitTest {

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleController vehicleController;

    @Test
    public void testGetVehiclesById() {
        // Given
        given(vehicleService.findVehicleById(1L)).willReturn(new Vehicle(1L, "BMW", "X5M", "black"));
        // When
        Vehicle vehicle = vehicleController.getVehicleById(1L);
        // Then
        assertThat(vehicle.getColor(), Matchers.equalTo("black"));
    }

    @Test
    public void testSaveVehicle() {
        // Given
        Vehicle vehicle = new Vehicle(2L, "Audi", "A8", "black");
        given(vehicleService.saveVehicle(Mockito.any(Vehicle.class))).willReturn(vehicle);
        // When
        Vehicle savedVehicle = vehicleController.saveVehicle(vehicle);
        // Then
        assertThat(savedVehicle.getColor(), Matchers.equalTo("black"));
    }
}