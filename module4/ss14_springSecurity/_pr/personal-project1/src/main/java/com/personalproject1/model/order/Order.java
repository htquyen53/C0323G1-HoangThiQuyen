package com.personalproject1.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.personalproject1.model.customer.Customer;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_status")
    private boolean orderStatus;
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    @JsonBackReference
    private Set<OrderDetail> orderDetailSet;

    public Order() {
    }

    public Order(Integer orderId, boolean orderStatus, Date orderDate, Customer customer, User user, Set<OrderDetail> orderDetailSet) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.customer = customer;
        this.user = user;
        this.orderDetailSet = orderDetailSet;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
