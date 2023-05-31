package case_study.furama_resort.model.service;

public class Service {
    private String id;
    private String name;
    private Double usableArea;
    private Double price;
    private int maxQuantity;
    private String typeRental;

    public Service() {
    }

    public Service(String id, String name, Double usableArea, Double price, int maxQuantity, String typeRental) {
        this.id = id;
        this.name = name;
        this.usableArea = usableArea;
        this.price = price;
        this.maxQuantity = maxQuantity;
        this.typeRental = typeRental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", usableArea=" + usableArea +
                ", price=" + price +
                ", maxQuantity=" + maxQuantity +
                ", typeRental='" + typeRental + '\'' +
                '}';
    }
}
