package com.product_management.repository;

import com.product_management.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Kem chống năng",150000, "dùng cho da nhạy cảm","Anessa Nhật Bản"));
        products.put(2, new Product(2,"Sữa rửa mặt",165000, "sạch sâu","Anessa Nhật Bản"));
        products.put(3, new Product(3,"Tây da chết",90000, "tẩy da chết lành tính","cocoon Việt Nam"));
        products.put(4, new Product(4,"Nước hoa hồng",170000, "làm sạch, cân bằng","Inisfree Hàn Quốc"));
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>(products.values());
        return productList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getIdProduct(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
