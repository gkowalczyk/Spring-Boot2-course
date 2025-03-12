package com.example.carapitesting.repositories;

import com.example.carapitesting.entities.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldReturnElementsByColor() {
        // given
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", "Red");
        vehicleRepository.save(vehicle);

        // when
        List<Vehicle> actual = (List<Vehicle>) vehicleRepository.findAllByColor("Red");

        // then
        Assertions.assertEquals("Toyota", actual.get(0).getBrand());
    }
}
