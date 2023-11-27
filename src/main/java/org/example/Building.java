package org.example;

import java.util.*;

public class Building implements IBuildingManagementSystem {
    private Map<UUID, String> buildings = new HashMap<>();
    private Map<UUID, List<String>> buildingDevices = new HashMap<>();
    private Map<UUID, List<String>> buildingActuators = new HashMap<>();

    public Building(UUID buildingId, String buildingName) {
        buildings.put(buildingId, buildingName);
    }

    @Override
    public Map<UUID, String> getBuildingInformation() {
        return buildings;
    }

    @Override
    public List<String> getSensorInformation(UUID buildingId) {
        return buildingDevices.getOrDefault(buildingId, Collections.emptyList());
    }

    @Override
    public List<String> getActuatorInformation(UUID buildingId) {
        return buildingActuators.getOrDefault(buildingId, Collections.emptyList());
    }

    @Override
    public UUID addTemperatureSensor(UUID buildingId, String name) {
        TempSensor newTempSensor = new TempSensor(name, UUID.randomUUID());
        addDeviceToBuilding(buildingId, name);
        return newTempSensor.getSensorID();
    }

    @Override
    public UUID addCo2Sensor(UUID buildingId, String name) {
        CO2Sensor newCO2Sensor = new CO2Sensor(name, UUID.randomUUID());
        addDeviceToBuilding(buildingId, name);
        return newCO2Sensor.getSensorID();
    }

    @Override
    public void removeSensor(UUID buildingId, UUID sensorId) {
        removeDeviceFromBuilding(buildingId, sensorId);
    }

    @Override
    public UUID addVentilationActuator(UUID buildingId, String name) {
        Actuator newActuator = new Actuator(name, UUID.randomUUID());
        addActuatorToBuilding(buildingId, name);
        return newActuator.getActuatorID();
    }

    @Override
    public void removeActuator(UUID buildingId, UUID actuatorId) {
        removeDeviceFromBuilding(buildingId, actuatorId);
    }

    private void addDeviceToBuilding(UUID buildingId, String deviceName) {
        buildingDevices.computeIfAbsent(buildingId, k -> new ArrayList<>()).add(deviceName);
    }

    private void addActuatorToBuilding(UUID buildingId, String actuatorName) {
        buildingActuators.computeIfAbsent(buildingId, k -> new ArrayList<>()).add(actuatorName);
    }

    private void removeDeviceFromBuilding(UUID buildingId, UUID deviceId) {
        buildingDevices.computeIfPresent(buildingId, (k, v) -> {
            v.removeIf(device -> deviceId.toString().equals(device));
            return v.isEmpty() ? null : v;
        });
        buildingActuators.computeIfPresent(buildingId, (k, v) -> {
            v.removeIf(device -> deviceId.toString().equals(device));
            return v.isEmpty() ? null : v;
        });
    }
}
