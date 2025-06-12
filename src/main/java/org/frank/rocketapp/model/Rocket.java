package org.frank.rocketapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rocket {
    private String name;
    private String model;

}
