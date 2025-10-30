package com.pluralsight;
import java.io.*;

public class DealershipFileManager {


    public Dealership loadDealership (String csvFile){
        Dealership dealership = new Dealership("Johns cars", "1123 Sugar strt","712-121-2332");
        //code to read the inventory.csv file
        //to do : figure out how to sow dealership information
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

                    //command to print out all vehicles

                    Vehicle v = new Vehicle(vin, year, make,color, model, vehicleType, odometer, price);
                    dealership.addVehicle(v);

                }
            }


        } catch (IOException e){
            System.out.println("Error reading file");
        }
        return  dealership;
    }


    public static void saveDealership(Dealership dealership){
        try{ FileWriter filewriter = new FileWriter("inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
            for (Vehicle v : dealership.getAllVehicles()){
                bufferedWriter.write(v.getVin()+ "|" +
                        v.getYear() + "|" +
                        v.getMake() + "|" +
                        v.getColor() + "|" +
                        v.getModel() + "|" +
                        v.getVehicleType() + "|" +
                        v.getOdometer() + "|" +
                        v.getPrice() + "|");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        }catch (Exception e){

        }

    }
}
