package com.product_management.service;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> displayAll() {
        return productRepository.getAll();
    }

    @Override
    public void save(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public boolean update(int id, Product product) {
        return productRepository.update(id, product);
    }

    @Override
    public boolean remove(int id) {
        return productRepository.remove(id);
    }
}
