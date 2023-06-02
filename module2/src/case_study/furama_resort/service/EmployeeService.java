package case_study.furama_resort.service;

import case_study.furama_resort.model.human.Employee;
import case_study.furama_resort.repository.EmployeeRepository;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static EmployeeRepository employeeRepository = new EmployeeRepository();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    @Override
    public void addNew() {

    }

    @Override
    public void editInfo() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {
        int option;
        do {
            System.out.println("Select option: \n" +
                    "1. Search by ID! \n" +
                    "2. Search by Name! \n" +
                    "3. Return Employees Management Menu \n" +
                    "Enter here: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option == 1) {
                    System.out.println("Enter ID here: ");
                    String fID = scanner.nextLine();
                    System.out.println("Result: " + employeeRepository.findByID(fID));
                } else if (option == 2) {
                    System.out.println("Enter name here: ");
                    String name = scanner.nextLine();
                    System.out.println("Result: \n" + employeeRepository.findByName(name));
                } else {
                    throw new NumberFormatException("Enter wrong Format Number!");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error in runtime!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
