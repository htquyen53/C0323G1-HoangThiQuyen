package case_study.furama_resort.service;

import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.model.facility.House;
import case_study.furama_resort.model.facility.Room;
import case_study.furama_resort.model.facility.Villa;
import case_study.furama_resort.repository.FacilityRepository;
import case_study.furama_resort.repository.IFacilityRepository;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static final IFacilityRepository facilityRepository = new FacilityRepository();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("Choose an option to display: \n" +
                "1. Display Villa \n" +
                "2. Display House \n" +
                "3. Display Room \n" +
                "Enter Here: ");
        int option;
        option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                displayVillas();
                break;
            case 2:
                displayHouse();
                break;
            case 3:
                displayRoom();
                break;
            default:
                System.out.println("You enter wrong function!");
        }
    }

    @Override
    public void displayVillas() {
        Map<Facility, Integer> facilityMap = facilityRepository.getAll();
        for (Facility f : facilityMap.keySet()) {
            if (f.getId().contains("VL")) {
                System.out.println(f);
            }
        }
    }

    @Override
    public void displayHouse() {
        Map<Facility, Integer> facilityMap = facilityRepository.getAll();
        for (Facility f : facilityMap.keySet()) {
            if (f.getId().contains("HO")) {
                System.out.println(f);
            }
        }
    }

    @Override
    public void displayRoom() {
        Map<Facility, Integer> facilityMap = facilityRepository.getAll();
        for (Facility f : facilityMap.keySet()) {
            if (f.getId().contains("RO")) {
                System.out.println(f);
            }
        }
    }

    // Villa(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String roomStandard, Double poolArea, int floor)
    // House(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String roomStandard, int floor)
    // Room(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String freeService)
    @Override
    public void addNew() {
        int option;
        do {
            System.out.println("You want to add new: \n" +
                    "1. Add New Villa \n" +
                    "2. Add New House \n" +
                    "3. Add New Room \n" +
                    "4. Back to menu" +
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
                        if (maxQuantity > 0 && maxQuantity <= 20) {
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
                    System.out.println("Enter room standard of villa: ");
                    try {
                        roomStandard = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(roomStandard)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                double poolArea;
                do {
                    System.out.println("Enter pool area of Villa: ");
                    try {
                        poolArea = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                int floor;
                do {
                    System.out.println("Enter number of floor of villa: ");
                    try {
                        floor = Integer.parseInt(scanner.nextLine());
                        if (floor <= 0) {
                            System.out.println("The number of floor must be positive integer!");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format number!");
                    }
                } while (true);
                Facility villa = new Villa(id, name, usableArea, price, maxQuantity, typeRental, roomStandard, poolArea, floor);
                facilityRepository.addNew(villa, 0);
                break;
            case 2:
                String idHouse;
                do {
                    System.out.println("Enter id of House: ");
                    try {
                        idHouse = scanner.nextLine();
                        if (facilityRepository.checkFacilityID(idHouse) != null) {
                            System.out.println("This ID exist!");
                        } else if (!Validate.checkHouseID(idHouse)) {
                            throw new IllegalInputException("This ID does not validate!");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String nameHouse;
                do {
                    System.out.println("Enter name of house: ");
                    try {
                        nameHouse = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(nameHouse)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                double usableAreaHouse;
                do {
                    System.out.println("Enter usable area of House: ");
                    try {
                        usableAreaHouse = Double.parseDouble(scanner.nextLine());
                        if (usableAreaHouse > 30) {
                            break;
                        } else {
                            System.out.println("The usable area must be more 30 m2!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                double priceHouse;
                do {
                    System.out.println("Enter price of house: ");
                    try {
                        priceHouse = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                int maxQuantityHouse;
                do {
                    System.out.println("Enter max of quantity of house: ");
                    try {
                        maxQuantityHouse = Integer.parseInt(scanner.nextLine());
                        if (maxQuantityHouse > 0 && maxQuantityHouse <= 20) {
                            break;
                        } else {
                            System.out.println("The maximum number of people must be greater than 0 and less than 20!!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                String typeRentalHouse;
                do {
                    System.out.println("Enter type rental of house: ");
                    try {
                        typeRentalHouse = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(typeRentalHouse)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String roomStandardHouse;
                do {
                    System.out.println("Enter room standard of house: ");
                    try {
                        roomStandardHouse = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(roomStandardHouse)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                int floorHouse;
                do {
                    System.out.println("Enter number of floor of house: ");
                    try {
                        floorHouse = Integer.parseInt(scanner.nextLine());
                        if (floorHouse <= 0) {
                            System.out.println("The number of floor must be positive integer!");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format number!");
                    }
                } while (true);
                Facility house = new House(idHouse, nameHouse, usableAreaHouse, priceHouse, maxQuantityHouse, typeRentalHouse, roomStandardHouse, floorHouse);
                facilityRepository.addNew(house, 0);
                break;
            case 3:
                String idRoom;
                do {
                    System.out.println("Enter id of room: ");
                    try {
                        idRoom = scanner.nextLine();
                        if (facilityRepository.checkFacilityID(idRoom) != null) {
                            System.out.println("This ID exist!");
                        } else if (!Validate.checkRoomID(idRoom)) {
                            throw new IllegalInputException("This ID does not validate!!");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String nameRoom;
                do {
                    System.out.println("Enter name of room: ");
                    try {
                        nameRoom = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(nameRoom)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                double usableAreaRoom;
                do {
                    System.out.println("Enter usable area of room: ");
                    try {
                        usableAreaRoom = Double.parseDouble(scanner.nextLine());
                        if (usableAreaRoom > 30) {
                            break;
                        } else {
                            System.out.println("The usable area must be more 30 m2!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                double priceRoom;
                do {
                    System.out.println("Enter price of room: ");
                    try {
                        priceRoom = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                int maxQuantityRoom;
                do {
                    System.out.println("Enter max of quantity of room: ");
                    try {
                        maxQuantityRoom = Integer.parseInt(scanner.nextLine());
                        if (maxQuantityRoom > 0 && maxQuantityRoom <= 20) {
                            break;
                        } else {
                            System.out.println("The maximum number of people must be greater than 0 and less than 20!!!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Enter wrong number format!");
                    }
                } while (true);
                String typeRentalRoom;
                do {
                    System.out.println("Enter type rental of room: ");
                    try {
                        typeRentalRoom = scanner.nextLine().toUpperCase();
                        if (!Validate.checkInput(typeRentalRoom)) {
                            throw new IllegalInputException("Enter alphanumeric characters only! Please re-enter:");
                        }
                        break;
                    } catch (IllegalInputException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                String freeService;
                System.out.println("Enter free service of room: ");
                freeService = scanner.nextLine().toUpperCase();
                Facility newRoom = new Room(idRoom, nameRoom, usableAreaRoom, priceRoom, maxQuantityRoom, typeRentalRoom, freeService);
                facilityRepository.addNew(newRoom, 0);
                break;
            case 4:
                break;
            default:
                System.out.println("You enter wrong option!");
        }
    }

    @Override
    public void displayMaintenance() {
        System.out.println("Maintenance list: ");
        Map<Facility, Integer> facilitiesMap = facilityRepository.getAll();
        for (Facility key: facilitiesMap.keySet()) {
            if (facilitiesMap.get(key) >= 5) {
                System.out.println("- " + key);
            }
        }
    }
}
