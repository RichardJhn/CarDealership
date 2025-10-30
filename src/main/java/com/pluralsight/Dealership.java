package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {

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

    public static void addVehicle(Vehicle vehicle) {
        try{
            Scanner scanner = new Scanner(System.in);
            FileWriter myWriter = new FileWriter("inventory.csv", true);
            System.out.println("What is the vin number? (5 numbers)");
            int vin = scanner.nextInt();
            System.out.println("What is the year?");
            int year = scanner.nextInt();
            System.out.println("What is the make?");
            String make = scanner.nextLine();
            System.out.println("What is the color?");
            String color = scanner.nextLine();
            System.out.println("what is the model?");
            String model = scanner.nextLine();
            System.out.println("What is the vehicle type?");
            String vehicleType = scanner.nextLine();
            System.out.println("What is the mileage?");
            int mileage = scanner.nextInt();
            System.out.println("How much are you selling it for?");
            double price = scanner.nextDouble();
            scanner.nextLine();

            myWriter.write(String.format("\n%s|%s|%s|%s|%s|%s|%s|%.2f",vin, year, make, color,model,vehicleType, mileage, price));
            myWriter.close();


        } catch (IOException e) {

        }
    }




    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehicleByYear(int min, int max){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getYear() >= min && v.getYear() <= max){
                result.add(v);
            }

        }
        return result;
    }
    public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> result = new ArrayList<>();
        for ( Vehicle v : inventory){
            if (v.getColor().equalsIgnoreCase(color)){
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> getVehicleByMileage(double min, double max){
        List<Vehicle> result = new ArrayList<>();
        for ( Vehicle v : inventory){
            if (v.getOdometer() >= min && v.getOdometer() <= max){
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> getVehicleByType(String type){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getVehicleType().equalsIgnoreCase(type)){
                result.add(v);
            }
        }
        return result;
    }


}



