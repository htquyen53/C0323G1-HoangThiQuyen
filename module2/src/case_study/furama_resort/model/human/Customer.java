package case_study.furama_resort.model.human;

public class Customer extends Person {
    private String typeCustomer;
    private String address;
    private String bookingID;
    private String bookingDate;
    private String startDay;
    private String endDay;
    private String serviceID;
    public Customer(){
    }

    public Customer(String typeCustomer, String address, String bookingID, String bookingDate, String startDay, String endDay, String serviceID) {
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.startDay = startDay;
        this.endDay = endDay;
        this.serviceID = serviceID;
    }

    public Customer(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email, String typeCustomer, String address, String bookingID, String bookingDate, String startDay, String endDay, String serviceID) {
        super(id, name, birthday, gender, citizenID, numberPhone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.startDay = startDay;
        this.endDay = endDay;
        this.serviceID = serviceID;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", serviceID='" + serviceID + '\'' +
                '}';
    }
}
