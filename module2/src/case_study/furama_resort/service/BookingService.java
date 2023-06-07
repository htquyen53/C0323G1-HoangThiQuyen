package case_study.furama_resort.service;

import case_study.furama_resort.controller.CustomerController;
import case_study.furama_resort.model.human.Customer;
import case_study.furama_resort.model.services.Booking;
import case_study.furama_resort.repository.*;
import case_study.furama_resort.utils.IllegalInputException;
import case_study.furama_resort.utils.Validate;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookingService implements IBookingService {
    private static final IBookingRepository BOOKING_REPOSITORY = new BookingRepository();
    private static final ICustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
    private static final ICustomerService CUSTOMER_SERVICE = new CustomerService();
    private static final IFacilityRepository FACILITY_REPOSITORY = new FacilityRepository();
    private static final Scanner scanner = new Scanner(System.in);

    //    Booking(String bookingID, String bookingDay, String startDay, String endDay, String customerID, String facilityID)
    @Override
    public void addNewBooking() {
        String bookingID;
        do {
            System.out.println("Enter Booking ID: ");
            try {
                bookingID = scanner.nextLine();
                if (!Validate.checkBookingID(bookingID)) {
                    throw new IllegalInputException("Wrong format, please re-enter with: BOK-0001");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String bookingDay;
        do {
            System.out.println("Enter Booking Day: ");
            try {
                bookingDay = scanner.nextLine();
                if (!Validate.checkDate(bookingDay)) {
                    throw new IllegalInputException("Wrong format, please re-enter with: 01/01/2023");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String startDay;
        do {
            System.out.println("Enter Start Day: ");
            try {
                startDay = scanner.nextLine();
                if (!Validate.checkDate(startDay)) {
                    throw new IllegalInputException("Wrong format, please re-enter with: 01/01/2023");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String endDay;
        do {
            System.out.println("Enter End Day: ");
            try {
                endDay = scanner.nextLine();
                if (!Validate.checkDate(endDay)) {
                    throw new IllegalInputException("Wrong format, please re-enter with: 01/01/2023");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        String customerID;
        String citizenID;
        do {
            System.out.println("Enter customer citizenID: ");
            citizenID = scanner.nextLine();
            if (CUSTOMER_REPOSITORY.getByCitizenID(citizenID) != null) {
                customerID = CUSTOMER_REPOSITORY.getByCitizenID(citizenID).getId();
                break;
            } else {
                CUSTOMER_SERVICE.addNew();
            }
        } while (true);
        String facilityID;
        do {
            System.out.println("Enter ID facility:");
            facilityID = scanner.nextLine();
            if (FACILITY_REPOSITORY.getFacilityID(facilityID) != null) {
                break;
            }
            System.out.println("Enter wrong ID, please re-enter!");
        } while (true);
        BOOKING_REPOSITORY.add(new Booking(bookingID, bookingDay, startDay, endDay, customerID, facilityID));
        System.out.println("Add new successful!");
    }

    @Override
    public void displayBooking() {
        System.out.println("BOOKING LIST:");
        Set<Booking> bookingSet = BOOKING_REPOSITORY.getAll();
        for (Booking b: bookingSet) {
            System.out.println(b);
        }
    }

    @Override
    public void creatNewContract() {

    }

    @Override
    public void displayContract() {

    }

    @Override
    public void editContract() {

    }
}
