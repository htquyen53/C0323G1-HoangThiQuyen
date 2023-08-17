package com.personalproject1.dto;

import com.personalproject1.model.product.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productImgPath;
    private ProductType ProductType;

    public ProductDto() {
    }

    public ProductDto(Integer productId, String productName, Double productPrice, String productDescription, String productImgPath, com.personalproject1.model.product.ProductType productType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImgPath = productImgPath;
        ProductType = productType;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
