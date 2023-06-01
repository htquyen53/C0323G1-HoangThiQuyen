package case_study.furama_resort.service;

import case_study.furama_resort.controller.FuramaController;
import case_study.furama_resort.model.human.Customer;
import case_study.furama_resort.model.human.Employee;
import case_study.furama_resort.repository.CustomerRepository;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static CustomerRepository customerRepository = new CustomerRepository();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        List<Customer> customers = customerRepository.getAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNew() {
        String idNew = "";
        do {
            System.out.println("Enter id of new customer: ");
            try {
                idNew = scanner.nextLine();
                if (!Validate.checkCustomerID(idNew)) {
                    throw new IllegalInputException("You have entered wrong format id, please re-enter!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        if (customerRepository.getByID(idNew) == null) {
            String name = "";
            do {
                System.out.println("Enter the name of customer: ");
                try {
                    name = scanner.nextLine();
                    if (!Validate.checkName(name)) {
                        throw new IllegalInputException("You have entered wrong format name, please re-enter");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            String birthday = "";
            do {
                System.out.println("Enter the birthday of customer: ");
                try {
                    birthday = scanner.nextLine();
                    if (!Validate.checkBirthday(birthday)) {
                        throw new IllegalInputException("You have entered wrong format birthday, please re-enter");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            boolean gender = false;
            int choose;
            do {
                System.out.println("Enter gender: \n" +
                        "1. Male\n" +
                        "2. Female");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1) {
                        gender = true;
                    } else if (choose == 2) {
                        gender = false;
                    } else {
                        throw new IllegalInputException("Enter wrong, please re-enter: 1 or 2!");
                    }
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("You entered the wrong format!");
                } catch (Exception e) {
                    System.out.println("Error");
                }
                break;
            } while (true);
            String citizenID = "";
            do {
                System.out.println("Enter the citizenID of customer: ");
                try {
                    citizenID = scanner.nextLine();
                    if (!Validate.checkCitizenID(citizenID)) {
                        throw new IllegalInputException("You have entered wrong format citizenID, please re-enter");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            String numberPhone = "";
            do {
                System.out.println("Enter the number phone of customer: ");
                try {
                    numberPhone = scanner.nextLine();
                    if (!Validate.checkNumberPhone(numberPhone)) {
                        throw new IllegalInputException("You have entered wrong format number phone, please re-enter");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            String email = "";
            do {
                System.out.println("Enter the email of customer: ");
                try {
                    email = scanner.nextLine();
                    if (!Validate.checkEmail(email)) {
                        throw new IllegalInputException("You have entered wrong format email, please re-enter");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            String typeCustomer = "";
            int option = 0;
            do {
                System.out.println("Enter the type of customer: \n" +
                        "1. Diamond \n" +
                        "2. Platinum \n" +
                        "3. Gold \n" +
                        "4. Silver \n" +
                        "5. Member");
                try {
                    option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1:
                            typeCustomer = "Diamond";
                            break;
                        case 2:
                            typeCustomer = "Platinum";
                            break;
                        case 3:
                            typeCustomer = "Gold";
                            break;
                        case 4:
                            typeCustomer = "Silver";
                            break;
                        case 5:
                            typeCustomer = "Member";
                            break;
                        default:
                            throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You entered wrong, please re-enter!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            String address = "";
            do {
                System.out.println("Enter the address of customer: ");
                try {
                    address = scanner.nextLine();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
            customerRepository.addNew(new Customer(idNew, name, birthday, gender, citizenID, numberPhone, email, typeCustomer, address));
            System.out.println("Add new successful!");
        } else {
            System.out.println("This id is exist!");
        }
    }

    @Override
    public void editInfo() {
        String editID;
        do {
            System.out.println("Enter id of customer you want to edit information: ");
            try {
                editID = scanner.nextLine();
                Customer editCustomer = customerRepository.getByID(editID);
                if (editCustomer != null) {
                    System.out.println("Customer whose code is " + editID + "is: " + editCustomer.getName() + ".\n" +
                            "Please enter a number to continue: \n" +
                            "1. Edit name \n" +
                            "2. Edit birthday \n" +
                            "3. Edit gender\n" +
                            "4. Edit citizenID \n" +
                            "5. Edit number phone \n" +
                            "6. Edit email \n" +
                            "7. Edit type of customer \n" +
                            "8. Edit Address \n" +
                            "9. Return main menu \n" +
                            "Enter here: ");
                    int option = 0;
                    switch (option) {
                        case 1:
                            System.out.println("Enter name: ");
                            String name = scanner.nextLine();
                            if (Validate.checkName(name)) {
                                editCustomer.setName(name);
                            } else {
                                throw new IllegalInputException("Enter wrong! Please re-enter with format: Hoang Quyen");
                            }
                            break;
                        case 2:
                            System.out.println("Edit birthday: ");
                            String birthday = scanner.nextLine();
                            if (Validate.checkBirthday(birthday)) {
                                editCustomer.setBirthday(birthday);
                            } else {
                                throw new IllegalInputException("Enter wrong! Please re-enter with format: 01/01/2000");
                            }
                            break;
                        case 4:
                            int choose = 0;
                            boolean gender;
                            System.out.println("Edit gender: \n" +
                                    "1. Male\n" +
                                    "2. Female");
                            try {
                                choose = Integer.parseInt(scanner.nextLine());
                                if (choose == 1) {
                                    gender = true;
                                } else if (choose == 2) {
                                    gender = false;
                                } else {
                                    throw new IllegalInputException("Enter wrong, please re-enter: 1 or 2!");
                                }
                                editCustomer.setGender(gender);
                                break;
                            } catch (IllegalInputException e) {
                                System.out.println(e.getMessage());
                            }
                        case 5:
                            System.out.println("Enter citizenID: ");
                            String citizenID = scanner.nextLine();
                            if (Validate.checkCitizenID(citizenID)) {
                                editCustomer.setCitizenID(citizenID);
                            } else {
                                throw new IllegalInputException("Enter wrong! Please re-enter with format: 123456789");
                            }
                            break;
                        case 6:
                            System.out.println("Enter number phone: ");
                            String editNumberPhone = scanner.nextLine();
                            if (Validate.checkNumberPhone(editNumberPhone)) {
                                editCustomer.setNumberPhone(editNumberPhone);
                            } else {
                                throw new IllegalInputException("Enter wrong! Please re-enter with format: 0123456789");
                            }
                            break;
                        case 7:
                            System.out.println("Enter email: ");
                            String editEmail = scanner.nextLine();
                            if (Validate.checkEmail(editEmail)) {
                                editCustomer.setEmail(editEmail);
                            } else {
                                throw new IllegalInputException("Enter wrong! Please re-enter with format: [ex: hq@gmail.com]");
                            }
                            break;
                        case 8:
                            String typeCustomer;
                            System.out.println("Enter type of customer: \n" +
                                    "1. Diamond \n" +
                                    "2. Platinum \n" +
                                    "3. Gold \n" +
                                    "4. Silver \n" +
                                    "5. Member");
                            try {
                                option = Integer.parseInt(scanner.nextLine());
                                switch (option) {
                                    case 1:
                                        typeCustomer = "Diamond";
                                        break;
                                    case 2:
                                        typeCustomer = "Platinum";
                                        break;
                                    case 3:
                                        typeCustomer = "Gold";
                                        break;
                                    case 4:
                                        typeCustomer = "Silver";
                                        break;
                                    case 5:
                                        typeCustomer = "Member";
                                        break;
                                    default:
                                        throw new IllegalInputException("Enter wrong! Please re-enter a number!");
                                }
                                editCustomer.setTypeCustomer(typeCustomer);
                                break;
                            } catch (IllegalInputException e) {
                                System.out.println(e.getMessage());
                            }
                        case 9:
                            FuramaController.displayMainMenu();
                        default:
                            System.out.println("Enter wrong!");
                    }
                } else {
                    System.out.println("Not exist!");
                }
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (true);
    }
}
