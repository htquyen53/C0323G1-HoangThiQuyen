package ss17.bai_tap.product_management.repository;

import ss17.bai_tap.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getProductByName(String name);
    List<Product> getAll();
}
