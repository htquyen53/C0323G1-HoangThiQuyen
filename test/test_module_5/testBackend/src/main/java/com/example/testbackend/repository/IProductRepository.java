package com.example.testbackend.repository;

import com.example.testbackend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    @Query(value = "select * from product where name like :searchName", nativeQuery = true)
    Page<Product> findAllByNameContaining(Pageable pageable, @Param(value = "searchName") String name);

    @Override
    void deleteById(Integer integer);
}
