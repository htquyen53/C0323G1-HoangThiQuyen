package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}
