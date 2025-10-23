package com.pluralsight;

public class Vehicle {
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    int odometer;
    double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    Vehicle(int vin, int year, String make, String model,
            String vehicleType, int odometer, double price){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin = " + vin +
                ", year = " + year +
                ", make =' " + make + '\'' +
                ", model =' " + model + '\'' +
                ", vehicleType =' " + vehicleType + '\'' +
                ", odometer = " + odometer +
                ", price = " + price +
                '}';
    }
}
