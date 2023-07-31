package com.example.cartmanagement.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    private boolean checkItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if(entry.getKey().getId().equals(productDto.getId())) {
                return true;
            }
        } return false;
    }
    private Map.Entry<ProductDto,Integer> selectItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto,Integer> entry:productMap.entrySet()) {
            if(entry.getKey().getId().equals(productDto.getId())) {
                return entry;
            }
        } return null;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
