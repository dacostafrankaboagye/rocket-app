package org.frank.rocketapp.controller;


import org.frank.rocketapp.model.Rocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rockets")
public class AppController {

    private final List<Rocket> rockets = List.of(
            Rocket.builder().name("Falcon 9").model("Block 5").build(),
            Rocket.builder().name("Starship").model("Prototype").build(),
            Rocket.builder().name("New Glenn").model("Orbital").build()
    );

    @GetMapping
    public List<Rocket> getAllRockets() {
        return rockets;
    }
}
