package org.example;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
            UUID building1 = UUID.randomUUID();


            Building build1 = new Building(building1, "Building1");

            build1.addCo2Sensor(building1, "CO2 Sensor");
            build1.addTemperatureSensor(building1, "TempSensor");
            build1.addVentilationActuator(building1, "Office vent");
            build1.addCo2Sensor(building1, "CO2 Sensor - 2");
            System.out.println(build1.getBuildingInformation());
            System.out.println(build1.getSensorInformation(building1));
            System.out.println(build1.getActuatorInformation(building1));


    }
}