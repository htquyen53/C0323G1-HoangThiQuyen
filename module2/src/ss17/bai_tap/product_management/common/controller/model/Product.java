package ss17.bai_tap.product_management.common.controller.model;

public class Product {
    private String productID;
    private String productName;
    private float price;
    private String manufacturer;
    private String description;

    public Product() {
    }

    public Product(String productID, String productName, float price, String manufacturer, String description) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }
    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
