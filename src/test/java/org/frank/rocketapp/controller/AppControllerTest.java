package org.frank.rocketapp.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AppController.class)
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllRockets() throws Exception {
        mockMvc.perform(get("/api/rockets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Falcon 9")))
                .andExpect(jsonPath("$[0].model", is("Block 5")))
                .andExpect(jsonPath("$[1].name", is("Starship")))
                .andExpect(jsonPath("$[1].model", is("Prototype")))
                .andExpect(jsonPath("$[2].name", is("New Glenn")))
                .andExpect(jsonPath("$[2].model", is("Orbital")));

    }
}