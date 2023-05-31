package case_study.furama_resort.controller;

import java.util.Scanner;

public class PromotionController {
    public static void displayPromotionMenu() {
        Scanner scanner = new Scanner(System.in);
        PROMOTION_MENU_WHILE:
        do{
            System.out.println("------FURAMA PROMOTION MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Display list customers use service\n" +
                    "2. Display list customers get voucher\n" +
                    "3. Return main menu");
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
                    FuramaController.displayMainMenu();
                    break PROMOTION_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}
