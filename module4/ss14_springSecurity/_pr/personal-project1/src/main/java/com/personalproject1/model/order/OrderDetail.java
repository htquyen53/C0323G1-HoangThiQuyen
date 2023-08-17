package com.personalproject1.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.personalproject1.model.product.Product;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    @Column(name = "quantity_product")
    private Integer quantityProduct;
    @Column(name = "product_price")
    private Double productPrice;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId, Integer quantityProduct, Double productPrice, Product product, Order order) {
        this.orderDetailId = orderDetailId;
        this.quantityProduct = quantityProduct;
        this.productPrice = productPrice;
        this.product = product;
        this.order = order;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
