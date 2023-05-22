package ss12.repository;

import ss12.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    Product getProductById(String id);

    Product getProductByName(String productName);

    void addProduct(Product product);

    void removeProduct(Product product);

    void productSortUp();
    void productSortDown();
}
