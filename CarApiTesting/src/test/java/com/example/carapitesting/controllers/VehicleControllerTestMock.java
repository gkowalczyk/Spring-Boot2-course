package com.example.carapitesting.controllers;

import com.example.carapitesting.entities.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc

class VehicleControllerTestMock {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnAllVehicles() throws Exception {
        // given
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        // when
        Vehicle[] vehicles = objectMapper.readValue(mockMvcResult.getResponse().getContentAsString(), Vehicle[].class);
        // then
        assertEquals(5, vehicles.length);
    }

    @Test
    public void shouldDeleteVehicle() throws Exception {
        // given
       mockMvc.perform(MockMvcRequestBuilders.delete("/api/vehicles/1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
    }
    @Test
    public void shouldReturn404WhenDelete() throws Exception {
        // given
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/vehicles/7"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
        String actual = mockMvcResult.getResolvedException().getMessage();
        // when
        // then
        assertEquals("No vehicle with such id: 7", actual);
    }
}