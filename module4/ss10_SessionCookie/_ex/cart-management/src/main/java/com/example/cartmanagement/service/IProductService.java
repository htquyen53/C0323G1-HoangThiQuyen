package com.example.cartmanagement.service;

import com.example.cartmanagement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Optional<Product> findByiD(Long id);
    Page<Product> showList(Pageable pageable, String name);
    boolean save(Product product);
    boolean update(Long id, Product product);
    boolean delete(Long id);
}
