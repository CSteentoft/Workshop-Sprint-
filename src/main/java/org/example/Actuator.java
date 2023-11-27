package org.example;

import java.util.UUID;

public class Actuator {
    private Double value;
    private String name;
    private UUID actuatorID;

    public Actuator(String name, UUID actuatorID) {

    }

    public UUID getActuatorID() {
        return actuatorID;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue(String name) {
        return value;
    }
}
