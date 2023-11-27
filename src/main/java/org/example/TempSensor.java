package org.example;

import java.util.UUID;

public class TempSensor extends Sensor {
    private Double value;

    public TempSensor(String name, UUID sensorID) {
        super(name, sensorID);
    }

    public Double getValue(){
        return value;
    }
}

