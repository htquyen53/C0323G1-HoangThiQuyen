package case_study.furama_resort.service;

import case_study.furama_resort.model.human.Employee;
import case_study.furama_resort.repository.EmployeeRepository;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final EmployeeRepository employeeRepository = new EmployeeRepository();
    private static final Scanner scanner = new Scanner(System.in);

    //    Employee(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email, String academicLevel, String jobPosition, Float salary)
    @Override
    public void displayList() {
        List<Employee> employeeList = employeeRepository.getAll();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNew() {
        String id;
        do {
            System.out.println("Enter id: ");
            try {
                id = scanner.nextLine();
                if (!Validate.checkEmployeeID(id)) {
                    throw new IllegalInputException("Enter wrong format id! Please enter with format: NV-1234");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String name;
        do {
            System.out.println("Enter name: ");
            try {
                name = scanner.nextLine();
                if (!Validate.checkName(name)) {
                    throw new IllegalInputException("Enter wrong format name! Please enter with format: Hoang Quyen");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String birthday;
        do {
            System.out.println("Enter birthday: ");
            try {
                birthday = scanner.nextLine();
                if (!Validate.checkBirthday(birthday)) {
                    throw new IllegalInputException("Enter wrong format date! Please enter with format: 01/01/1999");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        boolean gender;
        int optionGender;
        do {
            System.out.println("Enter gender: \n" +
                    "1. Male \n" +
                    "2. Female \n" +
                    "3. Other \n" +
                    "Enter here: ");
            try {
                optionGender = Integer.parseInt(scanner.nextLine());
                if (optionGender == 1) {
                    gender = true;
                    break;
                } else if (optionGender == 2) {
                    gender = false;
                    break;
                } else {
                    System.out.println("Enter wrong option! Please only enter a number of 1 | 2 | 3 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter wrong! Please only enter a number of 1 | 2 | 3 !");
            }
        } while (true);
        String citizenID;
        do {
            System.out.println("Enter citizenID: ");
            try {
                citizenID = scanner.nextLine();
                if (!Validate.checkCitizenID(citizenID)) {
                    throw new IllegalInputException("You have entered wrong citizenID, please re-enter!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        String numberPhone;
        do {
            System.out.println("Enter the number phone of employee: ");
            try {
                numberPhone = scanner.nextLine();
                if (!Validate.checkNumberPhone(numberPhone)) {
                    throw new IllegalInputException("You have entered wrong format number phone," +
                            "please re-enter with format: 0123456789");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        String email;
        do {
            System.out.println("Enter the email of employee: ");
            try {
                email = scanner.nextLine();
                if (!Validate.checkEmail(email)) {
                    throw new IllegalInputException("You have entered wrong format email, please re-enter with format: quyen@gmail.com");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        String academicLevel;
        int optionLevel;
        do {
            System.out.println("Enter employee level academic: ");
            try {
                optionLevel = Integer.parseInt(scanner.nextLine());
                switch (optionLevel) {
                    case 1:
                        academicLevel = "Intermediate";
                        break;
                    case 2:
                        academicLevel = "College";
                        break;
                    case 3:
                        academicLevel = "University";
                        break;
                    case 4:
                        academicLevel = "Postgraduate";
                        break;
                    default:
                        throw new IllegalInputException("Enter wrong! Please re-enter!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error!");
            }
        } while (true);
        String jobPosition;
        int optionJ;
        do {
            System.out.println("Enter job position: ");
            try {
                optionJ = Integer.parseInt(scanner.nextLine());
                switch (optionJ) {
                    case 1:
                        jobPosition = "Protocol";
                        break;
                    case 2:
                        jobPosition = "Serve";
                        break;
                    case 3:
                        jobPosition = "Specialist";
                        break;
                    case 4:
                        jobPosition = "Supervisor";
                        break;
                    case 5:
                        jobPosition = "Manager";
                        break;
                    case 6:
                        jobPosition = "Director";
                        break;
                    default:
                        throw new IllegalInputException("Enter wrong! Please re-enter!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error!");
            }
        } while (true);
        float salary;
        do {
            System.out.println("Enter the salary of employee: ");
            try {
                salary = Float.parseFloat(scanner.nextLine());
                if (salary > 1000000000) {
                    throw new IllegalInputException("You entered the limit allowed! Please re-enter:");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        employeeRepository.addNew(new Employee(id, name, birthday, gender, citizenID, numberPhone, email, academicLevel, jobPosition, salary));
    }

    @Override
    public void editInfo() {
        String editID;
        Employee editEmployee;
        System.out.println("Enter id: ");
        editID = scanner.nextLine();
        editEmployee = employeeRepository.findByID(editID);
        if (editEmployee != null) {
            LOOP_DO: do {
                System.out.println("Employee whose code = " + editID + " is: " + editEmployee);
            }
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {
        int option;
        loop_function:
        do {
            System.out.println("Select option: \n" +
                    "1. Search by ID! \n" +
                    "2. Search by Name! \n" +
                    "3. Return Employees Management Menu \n" +
                    "Enter here: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("Enter ID here: ");
                        String fID = scanner.nextLine();
                        System.out.println("Result: " + employeeRepository.findByID(fID));
                        break;
                    case 2:
                        System.out.println("Enter name here: ");
                        String name = scanner.nextLine();
                        System.out.println("Result: \n" + employeeRepository.findByName(name));
                        break;
                    case 3:
                        break loop_function;
                    default:
                        System.out.println("Enter wrong!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter wrong format!");
            } catch (RuntimeException e) {
                System.out.println("Error in runtime!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
