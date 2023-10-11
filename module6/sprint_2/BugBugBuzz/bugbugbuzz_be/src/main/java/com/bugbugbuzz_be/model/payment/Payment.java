package com.bugbugbuzz_be.model.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.product.Package;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "date")
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name="package_id", referencedColumnName = "id")
    private Package aPackage;
    @OneToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    public Payment() {
    }

    public Payment(Long id, String paymentDate, Package aPackage, AppUser appUser) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.aPackage = aPackage;
        this.appUser = appUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
