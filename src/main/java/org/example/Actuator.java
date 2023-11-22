package org.example;

public class Actuator {
    private Double value;
    private String name;
    private int actuatorID;

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue(String name) {
        return value;
    }
}
