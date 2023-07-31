package com.example.cartmanagement.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {
    private Long id;
    private String name;
    private String img;
    private double price;
    private String description;
    private short discount;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String img, double price, String description, short discount) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.description = description;
        this.discount = discount;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
