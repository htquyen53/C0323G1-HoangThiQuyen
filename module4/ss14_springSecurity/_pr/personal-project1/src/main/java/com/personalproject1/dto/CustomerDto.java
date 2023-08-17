package com.personalproject1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class CustomerDto implements Validator {
    private Integer customerId;
    private String customerName;
    private boolean customerGender;
    private Date customerBirthday;
    private boolean customerNumberPhone;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerName, boolean customerGender, Date customerBirthday, boolean customerNumberPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerBirthday = customerBirthday;
        this.customerNumberPhone = customerNumberPhone;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
