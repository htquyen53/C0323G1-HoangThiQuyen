package case_study.furama_resort.controller;

import java.util.Scanner;

public class FacilityController {
    public static void displayFacilityMenu() {
        Scanner scanner = new Scanner(System.in);
        FACILITY_MENU_WHILE:
        do{
            System.out.println("------FURAMA FACILITY MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Display list facility\n" +
                    "2. Add new facility\n" +
                    "3. Edit facility\n" +
                    "4. Return main menu");
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
                    FuramaController.displayMainMenu();
                    break FACILITY_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}
