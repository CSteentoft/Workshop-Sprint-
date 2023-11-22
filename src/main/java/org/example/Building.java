package org.example;

import java.util.List;

public class Building {
    private String buildingName;
    private List<Actuator> actuators;
    private List<Sensor> sensors;

    public List<Actuator> getActuators(String buildingName) {
        return actuators;
    }

    public List<Sensor> getSensors(String buildingName) {
        return sensors;
    }
    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
    }
    public Sensor addCO2Sensor(String name) {
        return null;
    }
}
