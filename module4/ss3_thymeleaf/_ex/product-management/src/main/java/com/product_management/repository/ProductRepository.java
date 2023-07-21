package com.product_management.repository;

import com.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> PRODUCTS = new HashMap<>();

    static {
        PRODUCTS.put(1, new Product(1, "Kem chống nắng", 120000, "bảo vệ da", "Hàn Quốc"));
        PRODUCTS.put(2, new Product(2, "Kem dưỡng da ban đêm", 120000, "bảo vệ da", "Hàn Quốc"));
        PRODUCTS.put(3, new Product(3, "Nước tẩy trang", 120000, "bảo vệ da", "Hàn Quốc"));
        PRODUCTS.put(4, new Product(4, "Xịt chống nắng", 120000, "bảo vệ da", "Hàn Quốc"));
        PRODUCTS.put(5, new Product(5, "Xịt thơm", 120000, "bảo vệ da", "Hàn Quốc"));
        PRODUCTS.put(6, new Product(6, "Kem chống nắng", 120000, "bảo vệ da", "Hàn Quốc"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(PRODUCTS.values());
    }

    @Override
    public void save(Product product) {
        PRODUCTS.put(product.getId(), product);
    }

    @Override
    public Product getById(int id) {
        return PRODUCTS.get(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCTS.put(id, product);
    }

    @Override
    public void remove(int id) {
        PRODUCTS.remove(id);
    }
}
