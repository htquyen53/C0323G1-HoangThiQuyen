package case_study.furama_resort.model.services;

public class Booking {
    private String bookingID;
    private String bookingDay;
    private String startDay;
    private String endDay;
    private String id;

    public Booking() {
    }

    public Booking(String bookingID, String bookingDay, String startDay, String endDay, String id) {
        this.bookingID = bookingID;
        this.bookingDay = bookingDay;
        this.startDay = startDay;
        this.endDay = endDay;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingDay='" + bookingDay + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
