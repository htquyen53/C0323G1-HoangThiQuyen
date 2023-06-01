package case_study.furama_resort.controller;

import case_study.furama_resort.service.CustomerService;
import case_study.furama_resort.service.ICustomerService;

import java.util.Scanner;

public class CustomerController {
    private static ICustomerService customerService = new CustomerService();
    public static void displayCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        CUSTOMER_MENU_WHILE:
        do{
            System.out.println("------FURAMA CUSTOMER MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Display list customers\n" +
                    "2. Add new customer\n" +
                    "3. Edit customer\n" +
                    "4. Delete customer \n" +
                    "5. Search for customer information\n" +
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
                    customerService.displayList();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.editInfo();
                    break;
                case 4:
                    customerService.delete();
                case 5:
                case 6:
                    FuramaController.displayMainMenu();
                    break CUSTOMER_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}
