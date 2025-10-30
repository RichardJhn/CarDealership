package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class UserInterface{

    private DealershipFileManager dealershipFileManager = new DealershipFileManager();
    private Dealership dealership = dealershipFileManager.getDealership();
    private ArrayList<Vehicle> inventory = new ArrayList<>();


    public void displayScreen() {
        Scanner scanner = new Scanner(System.in);
      //  DealershipFileManager dealershipFileManager = new DealershipFileManager();
      //  Dealership dealership = dealershipFileManager.loadDealership("inventory.csv");

        init();
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


            try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))){

                switch(choice.toString()){
                    case "1":
                        System.out.println("what is your minimum budget?");
                        double minBudget = scanner.nextDouble();
                        System.out.println("What is your Maximum budget?");
                        double maxBudget = scanner.nextDouble();
                        System.out.println("Here are the vehicles in your budget:");
                        for(Vehicle vehicle : dealership.getVehicleByPrice(minBudget, maxBudget))
                            System.out.println(vehicle);
                        break;
                    case "2":
                        System.out.println("What make are you looking for?");
                        String make = scanner.nextLine().trim();
                        System.out.println("What model are you looking for?");
                        String model = scanner.nextLine().trim();
                        System.out.println("Here are your results:");
                        for (Vehicle vehicle : dealership.getVehicleByMakeModel(make,model))
                            System.out.println(vehicle);
                        break;
                    case "3":
                        System.out.println("What is the earliest model are you looking for?");
                        int minYear = scanner.nextInt();
                        System.out.println("What is your oldest model you're looking for?");
                        int maxYear = scanner.nextInt();
                        System.out.println("Here are the vehicles you are looking for: ");
                        for(Vehicle vehicle : dealership.getVehicleByYear(minYear, maxYear))
                            System.out.println(vehicle);
                        break;
                    case "4":
                        System.out.println("What color would you like your vehicle to be?");
                        String userColor = scanner.nextLine();
                        System.out.println(dealership.getVehicleByColor(userColor));
                        break;
                    case "5":
                        System.out.println("Whats your minimum mileage?");
                        int minMileage = scanner.nextInt();
                        System.out.println("Whats your max mileage?");
                        int maxMileage = scanner.nextInt();
                        for (Vehicle vehicle : dealership.getVehicleByMileage(minMileage, maxMileage))
                            System.out.println(vehicle);
                        break;
                    case "6":
                        System.out.println("What type of vehicle would you like?");
                        String userType = scanner.nextLine();
                        for (Vehicle vehicle : dealership.getVehicleByType(userType))
                            System.out.println(vehicle);
                        break;
                    case "7":
                        for (Vehicle vehicle: dealership.getAllVehicles())
                            System.out.println(vehicle);
                        break;
                    case "8":
                        addNewVehicle();
                        break;
                    case "9":
                        proccessRemoveVehicle();
                        break;
                    case "99":
                        System.out.println("quitting");
                        return;
                    default:
                        System.out.println("Invalid entry! Please try again!");
                }
            }catch(Exception e){

            }
        }

    }
    // Initialize dealership from file
    private void init() {
        // creates and loads an object that can read/write the inventory file.
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();

        System.out.println("Loaded Dealership: " +
                dealership.getName() + " " +
                dealership.getAddress() + " " +
                dealership.getPhone());
    }

    private void proccessRemoveVehicle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("what is the vin number of the vehicle you would like to remove?(5 numbers)");
        Vehicle toRemove = null; // empty until found a matching VIN to remove
        int vin = Integer.parseInt(scanner.nextLine());
        ArrayList<Vehicle> inventory = new ArrayList<>();


        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                //    inventory.remove(v);
                toRemove = v;
                break;
            }
        }

        if (toRemove != null) {
            // remove the vehicle
            dealership.getAllVehicles().remove(toRemove);

            // save the updated dealership to CSV.
            DealershipFileManager.saveDealership(dealership);
            System.out.println("Vehicle has been removed ");

        }
        else {
            System.out.println("Vehicle with vin: " + vin + " not found.");
        }
    }
    public void addNewVehicle() {
        try{
            Scanner scanner = new Scanner(System.in);
            FileWriter myWriter = new FileWriter("inventory.csv", true);
            System.out.println("What is the vin number? (5 numbers)");
            int vin = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What is the year?");
            int year = scanner.nextInt();
            scanner.nextLine();
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
            scanner.nextLine();
            System.out.println("How much are you selling it for?");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Vehicle newVehicle = new Vehicle(vin, year, make, color, model,vehicleType,mileage,price);
            dealership.addVehicle(newVehicle);
            myWriter.write(String.format("" +
                            "\n%s|%s|%s|%s|%s|%s|%s|%.2f",
                    vin, year, make, color,model,vehicleType, mileage, price));
            myWriter.close();
            System.out.println("Vehicle added successfully!");

        } catch (IOException e) {
            System.out.println("Error while adding vehicle");

        }
    }




    //Have the Menu here



}
