package case_study.furama_resort.controller;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        MAIN_MENU_WHILE:
        do {
            System.out.println("--------FURAMA RESORT MANAGEMENT PROGRAM---------\n" +
                    "Welcome to Intelligent Furama Resort Management Program, please enter the number to continue!\n" +
                    "1. Employee Management \n" +
                    "2. Customer Management \n" +
                    "3. Facility Management \n" +
                    "4. Booking Management  \n" +
                    "5. Promotion Management\n" +
                    "6. Exit");
            int option = 0;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You have entered the wrong number format, please re-enter!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (option) {
                case 1:
                    EmployeeController.displayEmployeeMenu();
                    break;
                case 2:
                    CustomerController.displayCustomerMenu();
                    break;
                case 3:
                    FacilityController.displayFacilityMenu();
                    break;
                case 4:
                    BookingController.displayBookingMenu();
                    break;
                case 5:
                    PromotionController.displayPromotionMenu();
                    break;
                case 6:
                    break MAIN_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}