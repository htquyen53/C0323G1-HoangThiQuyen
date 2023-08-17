package com.personalproject1.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.personalproject1.model.order.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private boolean customerGender;
    private Date customerBirthday;
    private boolean customerNumberPhone;
    private Integer customerPoint;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Order> orderSet;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, boolean customerGender, Date customerBirthday, boolean customerNumberPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerBirthday = customerBirthday;
        this.customerNumberPhone = customerNumberPhone;
    }

    public Customer(Integer customerId, String customerName, boolean customerGender, Date customerBirthday, boolean customerNumberPhone, Integer customerPoint, Set<Order> orderSet) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerBirthday = customerBirthday;
        this.customerNumberPhone = customerNumberPhone;
        this.customerPoint = customerPoint;
        this.orderSet = orderSet;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(boolean customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }

    public Integer getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(Integer customerPoint) {
        this.customerPoint = customerPoint;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
