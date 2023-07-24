package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    boolean add(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
        boolean update(int id, Product product);
    boolean remove(int id);

}
