package ss12.model;

public class Product {
    private String id;
    private String productName;
    private String productOrigin;
    private int quantity;
    private String description;
    private float price;
    public Product(){
    }

    public Product(String id, String productName, String productOrigin, int quantity, String description, float price) {
        this.id = id;
        this.productName = productName;
        this.productOrigin = productOrigin;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Sản phẩm {" +
                "Mã: '" + id + '\'' +
                ", Tên sản phẩm: '" + productName + '\'' +
                ", Xuất xứ: '" + productOrigin + '\'' +
                ", Số lượng: " + quantity +
                ", Mô tả: '" + description + '\'' +
                ", Giá: " + price +
                '}';
    }
}
