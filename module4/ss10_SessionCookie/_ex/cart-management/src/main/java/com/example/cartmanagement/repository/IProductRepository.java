package com.example.cartmanagement.repository;

import com.example.cartmanagement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByNameContaining(Pageable pageable, String name);

}
