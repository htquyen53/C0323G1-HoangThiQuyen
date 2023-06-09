package case_study.furama_resort.controller;


import case_study.furama_resort.service.EmployeeService;
import case_study.furama_resort.service.IEmployeeService;
import java.util.Scanner;

public class EmployeeController {
    private static final IEmployeeService employeeService = new EmployeeService();
    public static void displayEmployeeMenu() {
        Scanner scanner = new Scanner(System.in);
        EMPLOYEE_MENU_WHILE:
        do{
            System.out.println("------FURAMA EMPLOYEE MANAGEMENT PROGRAM------\n" +
                    "Please enter a number to continue!\n" +
                    "1. Display list employees\n" +
                    "2. Add new employee\n" +
                    "3. Edit employee\n" +
                    "4. Delete employee \n" +
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
                    employeeService.displayList();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.editInfo();
                    break;
                case 4:
                    employeeService.delete();
                    break;
                case 5:
                    employeeService.find();
                        break;
                case 6:
                    FuramaController.displayMainMenu();
                    break EMPLOYEE_MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("You have entered the wrong option, please re-enter!");
            }
        } while (true);
    }
}
