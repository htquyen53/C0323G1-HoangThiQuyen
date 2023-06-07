package case_study.furama_resort.repository;

import case_study.furama_resort.common.CompareBooking;
import case_study.furama_resort.common.ReadAndWriteCSV;
import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.model.facility.House;
import case_study.furama_resort.model.facility.Room;
import case_study.furama_resort.model.facility.Villa;
import case_study.furama_resort.model.human.Customer;
import case_study.furama_resort.model.services.Booking;

import java.util.*;

public class BookingRepository implements IBookingRepository {
    /**
     * Bước 1: Tạo một set để chứa danh sách booking (sử dụng TreeSet - để có thể sắp xếp các phần tử dựa trên giá trị của chúng).
     * Bước 2: Tạo lớp BookingComparator để để xứ sắp xếp và đảm bảo thông tin booking không bị trùng lặp
     *
     * @return
     */
//    Booking(String bookingID, String bookingDay, String startDay, String endDay, String customerID, String facilityID)
    private static final Set<Booking> BOOKING_SET = new TreeSet<>(new CompareBooking());
    private static final ICustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();
    private static final IFacilityRepository FACILITY_REPOSITORY = new FacilityRepository();
    private static final String BOOKING_LIST_PATH = "module2/src/case_study/furama_resort/data/booking.csv";

//    static {
//        List<Customer> customerList = CUSTOMER_REPOSITORY.getAll();
//        List<Villa> villaList = FACILITY_REPOSITORY.getVillaList();
//        List<House> houseList = FACILITY_REPOSITORY.getHouseList();
//        List<Room> roomList = FACILITY_REPOSITORY.getRoomList();
//    }

    @Override
    public Set<Booking> getAll() {
        List<String> strings = ReadAndWriteCSV.readFile(BOOKING_LIST_PATH);
        String[] infoBooking;
        for (String str : strings) {
            infoBooking = str.split(",");
            BOOKING_SET.add(new Booking(infoBooking[0], infoBooking[1], infoBooking[2], infoBooking[3], infoBooking[4], infoBooking[5]));
        }
        return BOOKING_SET;
    }


    public void add(Booking booking) {
        BOOKING_SET.add(booking);
        List<String> bookingStr = new ArrayList<>();
        for (Booking b : BOOKING_SET) {
            bookingStr.add(getInfoToCSV(b));
        }
        ReadAndWriteCSV.writeFile(bookingStr, BOOKING_LIST_PATH, true);
    }

    public String getInfoToCSV(Booking booking) {
        return booking.getBookingID() + "," + booking.getBookingDay() + "," + booking.getStartDay() + "," + booking.getEndDay() + "," + booking.getCustomerID() + "," + booking.getFacilityID();
    }

    @Override
    public List<Customer> getCustomerBookingInYear() {

        return null;
    }
}
