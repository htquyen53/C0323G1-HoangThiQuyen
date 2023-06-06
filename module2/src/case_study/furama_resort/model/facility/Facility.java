package case_study.furama_resort.model.facility;

import java.util.Objects;

public abstract class Facility {
    private String id;
    private String name;
    private double usableArea;
    private double price;
    private int maxQuantity;
    private String typeRental;

    public Facility() {
    }

    public Facility(String id, String name, double usableArea, double price, int maxQuantity, String typeRental) {
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

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return "Facility:" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", usableArea=" + usableArea +
                ", price=" + price +
                ", maxQuantity=" + maxQuantity +
                ", typeRental='" + typeRental + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(id, facility.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
