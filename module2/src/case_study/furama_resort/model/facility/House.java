package case_study.furama_resort.model.facility;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House() {
    }

    public House(String id, String name, double usableArea, double price, int maxQuantity, String typeRental, String roomStandard, int floor) {
        super(id, name, usableArea, price, maxQuantity, typeRental);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }
}
