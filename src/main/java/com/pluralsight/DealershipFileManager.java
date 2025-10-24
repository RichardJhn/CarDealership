package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private List<Vehicle> inventory = new ArrayList<>();
    public Dealership loadDealership (String csvFile){
        Dealership dealership = new Dealership("Johns cars", "1123 Sugar strt","712-121-2332");
        try(BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 8) {
                    int vin = Integer.parseInt(data[0]);
                    int year = Integer.parseInt(data[1]);
                    String make = data[2];
                    String color = data[3];
                    String model = data[4];
                    String vehicleType = data[5];
                    int odometer = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);

                    Vehicle v = new Vehicle(vin, year, make, model,color, vehicleType, odometer, price);
                    dealership.addVehicle(v);




                }
            }

            System.out.println(dealership.getAllVehicles());
        } catch (IOException e){
            System.out.println("Error reading file");
        }
        return  dealership;
    }
}
