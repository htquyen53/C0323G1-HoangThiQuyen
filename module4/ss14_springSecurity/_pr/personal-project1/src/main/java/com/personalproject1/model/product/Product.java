package com.personalproject1.model.product;
import com.personalproject1.model.order.OrderDetail;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productImgPath;
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id",nullable = false)
    private ProductType ProductType;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetailSet;

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice, String productDescription, String productImgPath, com.personalproject1.model.product.ProductType productType, Set<OrderDetail> orderDetailSet) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImgPath = productImgPath;
        ProductType = productType;
        this.orderDetailSet = orderDetailSet;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImgPath() {
        return productImgPath;
    }

    public void setProductImgPath(String productImgPath) {
        this.productImgPath = productImgPath;
    }

    public com.personalproject1.model.product.ProductType getProductType() {
        return ProductType;
    }

    public void setProductType(com.personalproject1.model.product.ProductType productType) {
        ProductType = productType;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}

