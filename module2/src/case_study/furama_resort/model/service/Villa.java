package case_study.furama_resort.model.service;

public class Villa extends House{
    private Double poolArea;
    public Villa(){
    }
    public Villa (String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental,String roomStandard, Double poolArea, int floor) {
        super(id, name, usableArea, price, maxQuantity, typeRental, roomStandard, floor);
        this.poolArea = poolArea;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "poolArea=" + poolArea +
                '}';
    }
}
