package case_study.furama_resort.controller;

import case_study.furama_resort.service.FacilityService;

import java.util.Scanner;

public class FacilityController {
    private static final FacilityService facilityService = new FacilityService();
    public static void displayFacilityMenu() {
        Scanner scanner = new Scanner(System.in);
        FACILITY_MENU_WHILE:
        do{
            System.out.println("------FURAMA FACILITY MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Display list facility\n" +
                    "2. Add new facility\n" +
                    "3. Display list facility maintenance\n"+
                    "4. Return main menu \n" +
                    "Enter here: ");
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
                    facilityService.display();
                    break;
                case 2:
                    facilityService.addNew();
                    break;
                case 3:
                    facilityService.displayMaintenance();
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
