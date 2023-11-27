package org.example;
import java.util.*;

public class BuildingAdministrator {
    private Map<UUID, Building> buildings = new HashMap<>();
    private Optional<UUID> currentBuildingId = Optional.empty();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BuildingAdministrator administrator = new BuildingAdministrator();
        administrator.run();
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Building Administrator Menu:");
            System.out.println("1. Create Building");
            System.out.println("2. Add Sensor to Building");
            System.out.println("3. Add Actuator to Building");
            System.out.println("4. View Building Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createBuilding();
                    break;
                case 2:
                    addSensorToBuilding();
                    break;
                case 3:
                    addActuatorToBuilding();
                    break;
                case 4:
                    viewBuildingInformation();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void createBuilding() {
        System.out.print("Enter building name: ");
        String buildingName = scanner.nextLine();

        UUID buildingId = UUID.randomUUID();
        Building newBuilding = new Building(buildingId, buildingName);
        buildings.put(buildingId, newBuilding);
        currentBuildingId = Optional.of(buildingId);

        System.out.println("Building created successfully!");
    }

    private void addSensorToBuilding() {
        if (!currentBuildingId.isPresent()) {
            System.out.println("No current building selected. Please create a building first.");
            return;
        }

        Building building = buildings.get(currentBuildingId.get());

        System.out.print("Enter sensor name: ");
        String sensorName = scanner.nextLine();

        System.out.println("Select sensor type:");
        System.out.println("1. Temperature Sensor");
        System.out.println("2. CO2 Sensor");
        int sensorType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sensorType) {
            case 1:
                building.addTemperatureSensor(currentBuildingId.get(), sensorName);
                break;
            case 2:
                building.addCo2Sensor(currentBuildingId.get(), sensorName);
                break;
            default:
                System.out.println("Invalid sensor type.");
        }

        System.out.println("Sensor added to the building!");
    }

    private void addActuatorToBuilding() {
        if (!currentBuildingId.isPresent()) {
            System.out.println("No current building selected. Please create a building first.");
            return;
        }

        Building building = buildings.get(currentBuildingId.get());

        System.out.print("Enter actuator name: ");
        String actuatorName = scanner.nextLine();

        building.addVentilationActuator(currentBuildingId.get(), actuatorName);
        System.out.println("Actuator added to the building!");
    }

    private void viewBuildingInformation() {
        if (!currentBuildingId.isPresent()) {
            System.out.println("No current building selected. Please create or select a building first.");
            return;
        }

        Building building = buildings.get(currentBuildingId.get());

        System.out.println("Building Information:");
        System.out.println("Name: " + building.getBuildingInformation().get(currentBuildingId.get()));
        System.out.println("Sensors: " + building.getSensorInformation(currentBuildingId.get()));
        System.out.println("Actuators: " + building.getActuatorInformation(currentBuildingId.get()));
    }

    private Optional<UUID> getBuildingIdByName(String buildingName) {
        return buildings.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getBuildingInformation().containsValue(buildingName))
                .map(Map.Entry::getKey)
                .findFirst();
    }
}

