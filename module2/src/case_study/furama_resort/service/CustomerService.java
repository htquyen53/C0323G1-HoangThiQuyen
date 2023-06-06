package case_study.furama_resort.service;

import case_study.furama_resort.model.human.Customer;
import case_study.furama_resort.repository.CustomerRepository;
import case_study.furama_resort.repository.ICustomerRepository;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final ICustomerRepository customerRepository = new CustomerRepository();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList() {
        List<Customer> customers = customerRepository.getAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void addNew() {
        String idNew;
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
        if (customerRepository.findByID(idNew) == null) {
            String name;
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
            String birthday;
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
            boolean gender;
            int choose;
            do {
                System.out.println("Enter gender: \n" +
                        "1. Male\n" +
                        "2. Female");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    if (choose == 1) {
                        gender = true;
                        break;
                    } else if (choose == 2) {
                        gender = false;
                        break;
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
            } while (true);
            String citizenID;
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
            String numberPhone;
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
            String email;
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
            String typeCustomer;
            int option;
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
            String address;
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
        Customer editCustomer;
        System.out.println("Enter id of customer you want to edit information: ");
        editID = scanner.nextLine();
        editCustomer = customerRepository.findByID(editID);
        if (editCustomer != null) {
            loop:
            do {
                System.out.println("Customer whose code is " + editID + " is: " + editCustomer.getName() + ".\n" +
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
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error format!");
                }
                switch (option) {
                    case 1:
                        do {
                            System.out.println("Enter name: ");
                            String name = scanner.nextLine();
                            if (Validate.checkName(name)) {
                                editCustomer.setName(name);
                                System.out.println("Edit successful!");
                                break;
                            } else {
                                System.out.println("Enter wrong! Please re-enter with format: Hoang Quyen");
                            }
                        } while (true);
                        break;
                    case 2:
                        do {
                            System.out.println("Edit birthday: ");
                            String birthday = scanner.nextLine();
                            if (Validate.checkBirthday(birthday)) {
                                editCustomer.setBirthday(birthday);
                                System.out.println("Edit successful!");
                                break;
                            } else {
                                System.out.println("Enter wrong! Please re-enter with format: 01/01/2000");
                            }
                        } while (true);
                        break;
                    case 3:
                        int choose;
                        boolean gender;
                        do {
                            System.out.println("Edit gender: \n" +
                                    "1. Male\n" +
                                    "2. Female");
                            choose = Integer.parseInt(scanner.nextLine());
                            if (choose == 1) {
                                gender = true;
                                break;
                            } else if (choose == 2) {
                                gender = false;
                                break;
                            } else {
                                System.out.println("Enter wrong, please re-enter: 1 or 2!");
                            }
                        } while (true);
                        editCustomer.setGender(gender);
                        System.out.println("Edit successful!");
                        break;
                    case 4:
                        do {
                            System.out.println("Enter citizenID: ");
                            String citizenID = scanner.nextLine();
                            if (Validate.checkCitizenID(citizenID)) {
                                editCustomer.setCitizenID(citizenID);
                                System.out.println("Edit successful!");
                                break;
                            } else {
                                System.out.println("Enter wrong! Please re-enter with format: 123456789");
                            }
                        } while (true);
                        break;
                    case 5:
                        do {
                            System.out.println("Enter number phone: ");
                            String editNumberPhone = scanner.nextLine();
                            if (Validate.checkNumberPhone(editNumberPhone)) {
                                editCustomer.setNumberPhone(editNumberPhone);
                                System.out.println("Edit successful!");
                                break;
                            } else {
                                System.out.println("Enter wrong! Please re-enter with format: 0123456789");
                            }
                        } while (true);
                        break;
                    case 6:
                        do {
                            System.out.println("Enter email: ");
                            String editEmail = scanner.nextLine();
                            if (Validate.checkEmail(editEmail)) {
                                editCustomer.setEmail(editEmail);
                                System.out.println("Edit successful!");
                                break;
                            } else {
                                System.out.println("Enter wrong! Please re-enter with format: [ex: hq@gmail.com]");
                            }
                        } while (true);
                        break;
                    case 7:
                        String typeCustomer;
                        String option_8;
                        LOOP_CASE_8:
                        do {
                            System.out.println("Enter type of customer: \n" +
                                    "1. Diamond \n" +
                                    "2. Platinum \n" +
                                    "3. Gold \n" +
                                    "4. Silver \n" +
                                    "5. Member");
                            option_8 = scanner.nextLine();
                            switch (option_8) {
                                case "1":
                                    typeCustomer = "Diamond";
                                    break LOOP_CASE_8;
                                case "2":
                                    typeCustomer = "Platinum";
                                    break LOOP_CASE_8;
                                case "3":
                                    typeCustomer = "Gold";
                                    break LOOP_CASE_8;
                                case "4":
                                    typeCustomer = "Silver";
                                    break LOOP_CASE_8;
                                case "5":
                                    typeCustomer = "Member";
                                    break LOOP_CASE_8;
                                default:
                                    System.out.println("Enter wrong! Please re-enter a number!");
                                    break;
                            }
                        } while (true);
                        editCustomer.setTypeCustomer(typeCustomer);
                        System.out.println("Edit successful!");
                        break;
                    case 8:
                        System.out.println("Update address:");
                        String updateAddress = scanner.nextLine();
                        editCustomer.setAddress(updateAddress);
                        System.out.println("Edit successful!");
                        break;
                    case 9:
                        break loop;
                    default:
                        System.out.println("Enter wrong!");
                }
            } while (true);
            customerRepository.edit(editCustomer);
        } else {
            System.out.println("ID does not exist!");
        }
    }

    @Override
    public void delete() {
        do {
            System.out.println("Enter ID:");
            String deleteID = scanner.nextLine();
            Customer deleteCustomer = customerRepository.findByID(deleteID);
            if (deleteCustomer != null) {
                customerRepository.delete(deleteCustomer);
                System.out.println("Delete successful!");
                break;
            }
            System.out.println("ID you entered does not exist!");
        } while (true);
    }

    @Override
    public void find() {


    }

//    @Override
//    public Customer findByID(String id) {
//        return null;
//    }
//
//    @Override
//    public Customer findByName(String name) {
//        return null;
//    }
}
