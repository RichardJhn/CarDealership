package com.pluralsight;
import java.util.Scanner;
import java.io.*;
public class UserInterface{

    public void displayScreen() {
        Scanner scanner = new Scanner(System.in);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.loadDealership("inventory.csv");


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

                switch(choice.toString()){
                    case "1":
                        System.out.println("what is your budget?");

                        break;
                        case "2":
                         case "3":

                         case "4":
                         case "5":
                         case "6":
                         case "7":
                             for (Vehicle vehicle: dealership.getAllVehicles())
                                 System.out.println(vehicle);
                         case "8":
                         case "9":
                         case "99":
                            return;
                         default:
                                System.out.println("Invalid entry! Please try again!");
                }
            }catch(Exception e){

            }
        }

    }






    //Have the Menu here



}
