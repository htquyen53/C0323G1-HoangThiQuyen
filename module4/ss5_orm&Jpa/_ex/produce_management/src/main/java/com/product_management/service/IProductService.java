package com.product_management.service;

import com.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();
    void save(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
    boolean update(int id, Product product);
    boolean remove(int id);
}
