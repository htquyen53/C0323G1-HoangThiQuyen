package codepractise.mvc.model;

import java.util.Objects;

public class Product {
    private String code;
    private String name;
    private String description;
    private float price;
    private int quantity;
    public Product(){
    }
    public Product(String code, String name, String description, float price, int quantity) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  "Mã sản phẩm: " + code + '\'' +
                ", Tên sản phẩm: '" + name + '\'' +
                ", Mô tả: '" + description + '\'' +
                ", Giá: " + price +
                ", Số lượng: " + quantity +
                '}';
    }
}
