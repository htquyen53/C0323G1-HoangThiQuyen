package case_study.furama_resort.model.service;

public class Room extends Service {
    private String freeService;
    public Room(){
    }
    public Room(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental, String freeService) {
        super(id, name, usableArea, price, maxQuantity, typeRental);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
