package com.example.carapitesting.services;

import com.example.carapitesting.controllers.VehicleController;
import com.example.carapitesting.entities.Vehicle;
import com.example.carapitesting.repositories.VehicleRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    public void testGetVehiclesById() {
        // Given
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(new Vehicle(1L, "BMW", "X5M", "black")));

        // When
        Vehicle vehicle = vehicleService.findVehicleById(1L);
        // Then
        assertThat(vehicle.getColor(), Matchers.equalTo("black"));
        verify(vehicleRepository, times(1)).findById(1L);
    }
}
