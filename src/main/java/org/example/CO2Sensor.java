package org.example;

import java.util.UUID;

public class CO2Sensor extends Sensor{
    private Double value;

    public CO2Sensor(String name, UUID sensorID) {
        super(name, sensorID);
    }

    public Double getValue(){
        return value;
    }
}
