package com.example.cartmanagement.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }
}
