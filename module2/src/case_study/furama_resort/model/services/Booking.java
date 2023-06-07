package case_study.furama_resort.model.services;

import java.util.Objects;

public class Booking {
    private String bookingID;
    private String bookingDay;
    private String startDay;
    private String endDay;
    private String customerID;
    private String facilityID;

    public Booking() {
    }

    public Booking(String bookingID, String bookingDay, String startDay, String endDay, String customerID, String facilityID) {
        this.bookingID = bookingID;
        this.bookingDay = bookingDay;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.facilityID = facilityID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingDay='" + bookingDay + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customerID='" + customerID + '\'' +
                ", facilityID='" + facilityID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingID, booking.bookingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID);
    }
}
