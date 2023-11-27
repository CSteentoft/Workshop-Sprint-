package org.example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BuildingAdministrator implements IBuildingManagementSystem{
    private List<Building> buildings;


    @Override
    public Map<UUID, String> getBuildingInformation() {
        return null;
    }

    @Override
    public Map<UUID, String> getSensorInformation(UUID buildingId) {
        return null;
    }

    @Override
    public Map<UUID, String> getActuatorInformation(UUID buildingId) {
        return null;
    }

    @Override
    public UUID addTemperatureSensor(UUID buildingId, String name) {
        return null;
    }

    @Override
    public UUID addCo2Sensor(UUID buildingId, String name) {
        return null;
    }

    @Override
    public void removeSensor(UUID buildingId, UUID sensorId) {

    }

    @Override
    public UUID addVentilationActuator(UUID buildingId, String name) {
        return null;
    }

    @Override
    public void removeActuator(UUID buildingId, UUID actuatorId) {

    }
}
