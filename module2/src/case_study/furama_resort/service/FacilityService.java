package case_study.furama_resort.service;

import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.repository.FacilityRepository;
import case_study.furama_resort.repository.IFacilityRepository;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityService implements IFacilityService {
    private static final IFacilityRepository facilityRepository = new FacilityRepository();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        Map<Facility, Integer> facilityList = facilityRepository.getAll();
        Set<Facility> facilities = facilityList.keySet();
        for (Facility f : facilities) {
            System.out.println(f);
        }
    }

    // Villa(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String roomStandard, Double poolArea, int floor)
    // House(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String roomStandard, int floor)
    // Room(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String freeService)
    @Override
    public void addNew() {
        Map<Facility, Integer> facilityList = facilityRepository.getAll();
        int option;
        do {
            System.out.println("You want to add new: \n" +
                    "1. Villa \n" +
                    "2. House \n" +
                    "3. Room \n" +
                    "Enter option here: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter wrong format number!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        switch (option) {
            case 1:
                String id;
                do {
                    System.out.println("Enter id of villa: ");
                    try {
                        id = scanner.nextLine();
                        if (facilityRepository.checkFacilityID(id) != null) {
                            System.out.println("This ID exist!");
                        } else if (!Validate.checkVillaID(id)) {
                            throw new IllegalInputException("Id does not validate");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String name;
                do {
                    System.out.println("Enter name of villa: ");
                    try {
                        name = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(name)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                double usableArea;
                do {
                    System.out.println("Enter usable area of villa: ");
                    try {
                        usableArea = Double.parseDouble(scanner.nextLine());
                        if (usableArea > 30) {
                            break;
                        } else {
                            System.out.println("The usable area must be more 30 m2!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                double price;
                do {
                    System.out.println("Enter price of villa: ");
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                int maxQuantity;
                do {
                    System.out.println("Enter max of quantity of villa: ");
                    try {
                        maxQuantity = Integer.parseInt(scanner.nextLine());
                        if (maxQuantity>0 && maxQuantity <=20) {
                            break;
                        } else {
                            System.out.println("The maximum number of people must be greater than 0 and less than 20!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                String typeRental;
                do {
                    System.out.println("Enter type rental of villa: ");
                    try {
                        typeRental = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(typeRental)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String roomStandard;
                do {
                    System.out.println("Enter type rental of villa: ");
                    try {
                        typeRental = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(typeRental)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                double poolArea;
                int floor;
                break;
            case 2:

            case 3:

            default:
        }
    }
}
