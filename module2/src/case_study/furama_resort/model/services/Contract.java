package case_study.furama_resort.model.services;

public class Contract {
    private String contractID;
    protected String bookingID;
    private Double deposit;
    private Double payment;
    public Contract(){
    }
    public Contract(String contractID, String bookingID, Double deposit, Double payment) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.payment = payment;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractID='" + contractID + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", deposit=" + deposit +
                ", payment=" + payment +
                '}';
    }
}
