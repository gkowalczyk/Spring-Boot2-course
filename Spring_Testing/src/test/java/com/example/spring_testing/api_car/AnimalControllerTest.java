package com.example.spring_testing.api_car;

import com.example.spring_testing.vehicle.entities.Vehicle;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {


    private AnimalController animalController = mock(AnimalController.class);
    @BeforeEach
    public void setUp() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal(1L, "dog"));
        list.add(new Animal(2L, "cat"));
        Mockito.when(animalController.getAnimals()).thenReturn(list);
    }
    @Test
    public void testGetAnimals() {
        // Arrange
        // Act
        // Assert
       assertThat(animalController.getAnimals(), Matchers.hasSize(2));
    }
    @Test
    public void addAnimalBDD() {
        //Given
        given(animalController.addAnimal(Mockito.any(Animal.class))).willReturn(new Animal(3L, "dog"));
        //When
        Animal animal = animalController.addAnimal(new Animal());
        //Then
        Assertions.assertEquals(animal.getName(), "dog");
    }
}
@ExtendWith(MockitoExtension.class)
class AnimalControllerTest2 {

    @Mock
    AnimalRepo animalRepo;

    @InjectMocks
    AnimalController animalController;

    @BeforeEach()
    public void setUp() {
       given(animalRepo.findAll()).willReturn(new ArrayList<Animal>() {{
           add(new Animal(1L, "dog"));
           add(new Animal(2L, "cat"));
       }});
    }

    @Test
    public void testGetAnimals() {
        // Arrange

        // Act
        List<Animal> animals = animalController.getAnimals();
        // Assert
        assertThat(animals, Matchers.hasSize(2));
    }

}