package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    Vehicle v1 = new Vehicle(112323, 2019, "Camry", "Toyota", "Sedan", 123213, 123214.00);

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v1.getMake().equalsIgnoreCase(v1.make) && v1.getModel().equalsIgnoreCase(v1.getModel())) {
                result.add(v);
            }
        }
        return result;
    }
}



