package com.example.testbackend.service.impl;

import com.example.testbackend.model.Product;
import com.example.testbackend.repository.IProductRepository;
import com.example.testbackend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable, String name) {
        return iProductRepository.findAllByNameContaining(pageable,name);
    }
}
