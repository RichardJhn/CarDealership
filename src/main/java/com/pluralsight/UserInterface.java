package com.pluralsight;
import java.util.Scanner;
import java.io.*;
public class UserInterface{
    private void displayScreen() {
        Scanner scanner = new Scanner(System.in);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = new Dealership("John's Car Dealership","3213 Mcdonalds Rd","783-123-4124");
        String choice = "";


        while (!choice.equalsIgnoreCase("99")){
            System.out.println("""
                    1 - Find vehicles withing price range
                    2 - Find vehicles by make/model
                    3 - Find Vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - Last ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit""");

            System.out.println("Enter your choice:");

            choice = scanner.nextLine().trim();

            //here we code the options


            if (choice.equalsIgnoreCase("99")){
                System.out.println("quiting");
                break;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))){
                String line;

                while((line = reader.readLine()) !=null){
                    String[] data = line.split(("\\|"));
                    if (data.length == 8){
                        int vin = Integer.parseInt(data[0]);
                        int year = Integer.parseInt(data[1]);
                        String make = data[2];
                        String color = data[3];
                        String model = data[4];
                        String vehicleType = data[5];
                        int odometer = Integer.parseInt(data[6]);
                        double price = Double.parseDouble(data[7]);

                        switch(choice.toString()){
                            case "1":
                                System.out.println("what is your budget?");
                                dealership.getVehicleByPrice(0.00, 100000.00);
                                break;
                            case "2":

                            case "3":
                            case "4":
                            case "5":
                            case "6":
                            case "7":
                            case "8":
                            case "9":
                            case "99":
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error - File not found");

            }


        }
        displayScreen();
    }


    //Have the Menu here



}
