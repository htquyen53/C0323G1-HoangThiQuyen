package case_study.furama_resort.controller;

import java.util.Scanner;

public class BookingController {
    public static void displayBookingMenu() {
        Scanner scanner = new Scanner(System.in);
        BOOKING_MENU_WHILE:
        do{
            System.out.println("------FURAMA BOOKING MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Add new booking\n" +
                    "2. Display list booking\n" +
                    "3. Creat new contracts\n" +
                    "4. Display list contracts" +
                    "5. Edit contracts\n" +
                    "6. Return main menu");
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    FuramaController.displayMainMenu();
                    break BOOKING_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}
