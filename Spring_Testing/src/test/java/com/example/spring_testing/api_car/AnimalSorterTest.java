package com.example.spring_testing.api_car;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AnimalSorterTest {

    @Spy
    AnimalSorter animalSorter;

    @BeforeEach
    public void init() throws JsonProcessingException {
        given(animalSorter.sortAnimals()).willReturn(prepareData());
        ;
    }

    public String[] prepareData() {
        String[] data = {"Pies", "Kot", "Szynszyl"};
        return data;
    }

    @Test
    void sortAnimals() throws JsonProcessingException {
        String[] sorted = {"Kot", "Pies", "Szynszyl"};
        assertArrayEquals(sorted, animalSorter.sortData());
    }
}