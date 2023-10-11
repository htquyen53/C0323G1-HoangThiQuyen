package com.bugbugbuzz_be.model.product;

import com.bugbugbuzz_be.model.payment.Payment;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "datetime")
    private String startDay;
    @Column(columnDefinition = "datetime")
    private String endDay;
    private Boolean isDeleted = false;
    private Double price;
    @OneToMany(mappedBy = "aPackage")
    private Set<Payment> paymentSet;

    public Package() {
    }

    public Package(Long id, String name, String startDay, String endDay, Boolean isDeleted, Double price, Set<Payment> paymentSet) {
        this.id = id;
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.isDeleted = isDeleted;
        this.price = price;
        this.paymentSet = paymentSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Payment> getPaymentSet() {
        return paymentSet;
    }

    public void setPaymentSet(Set<Payment> paymentSet) {
        this.paymentSet = paymentSet;
    }
}
