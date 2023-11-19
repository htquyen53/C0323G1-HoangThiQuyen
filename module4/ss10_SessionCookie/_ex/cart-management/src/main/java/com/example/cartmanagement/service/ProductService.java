package com.example.cartmanagement.service;

import com.example.cartmanagement.model.Product;
import com.example.cartmanagement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> showList(Pageable pageable, String name) {
        return productRepository.findAllByNameContaining(pageable, name);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product) != null;
    }

    @Override
    public boolean update(Long id, Product product) {
        Product productUpdate = productRepository.findById(id).get();
        return productUpdate != null;
    }

    @Override
    public boolean delete(Long id) {
        Product productDelete = productRepository.findById(id).get();
        return productDelete != null;
    }
}
