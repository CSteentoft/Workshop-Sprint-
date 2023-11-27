package org.example;

import java.util.UUID;

public class Sensor {
    private UUID sensorID;
    private String name;
    private Double value;

    public UUID getSensorID() {
        return sensorID;
    }

    public Sensor(String name, UUID sensorID) {

    }
}
