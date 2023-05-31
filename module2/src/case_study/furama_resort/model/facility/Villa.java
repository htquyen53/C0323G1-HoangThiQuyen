package case_study.furama_resort.model.facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private int floor;
    public Villa(){
    }

    public Villa(String roomStandard, Double poolArea, int floor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental, String roomStandard, Double poolArea, int floor) {
        super(id, name, usableArea, price, maxQuantity, typeRental);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }
}
