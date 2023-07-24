package com.product_management.repository;

import com.product_management.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        String keySearch="%"+name+"%";
        TypedQuery<Product> query = entityManager.createQuery("from Product p where p.name like :keySearch", Product.class);
       query.setParameter("keySearch",keySearch);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean update(int id, Product product) {
        Product product1 = findById(id);
        product1.setId(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setManufacturer(product.getManufacturer());
        try {
            entityManager.merge(product1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean remove(int id) {
        Product product = findById(id);
        try {
            entityManager.remove(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
