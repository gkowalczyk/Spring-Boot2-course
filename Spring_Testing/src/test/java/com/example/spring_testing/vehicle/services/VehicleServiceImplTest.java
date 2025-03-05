package com.example.spring_testing.vehicle.services;

import com.example.spring_testing.vehicle.entities.Vehicle;
import com.example.spring_testing.vehicle.repositories.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @BeforeEach
    public void setUp() {
        Iterable<Vehicle> vehicles = Arrays.asList(
                new Vehicle(1L, "Audi", "A4", "black"),
                new Vehicle(2L, "BMW", "X5", "white"),
                new Vehicle(3L, "Audi", "A6", "black")
        );
        doReturn(vehicles).when(vehicleRepository).findAll();
    }

    /*@Mock
    private VehicleRepository vehicleRepository;
    @InjectMocks // pozwala na wstrzyknięcie mocków do klasy VehicleServiceImpl
    private  VehicleService vehicleService = new VehicleServiceImpl();*/

    private final VehicleRepository vehicleRepository = mock(VehicleRepository.class);
    private final VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);

    @Test
    @DisplayName("Should return selected color")
    public void shouldReturnSelectedColor() {

       //when
        List<Vehicle> blackVehicles = vehicleService.findAllVehiclesByColor("black");

        //then
        assertEquals(2, blackVehicles.size());
        assertEquals("black", blackVehicles.get(0).getColor());
        assertEquals("black", blackVehicles.get(1).getColor());

    }
}