package ss17.bai_tap.product_management.common.controller.repository;

import ss17.bai_tap.product_management.common.controller.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getProductByName(String name);
    List<Product> getAll();

}
