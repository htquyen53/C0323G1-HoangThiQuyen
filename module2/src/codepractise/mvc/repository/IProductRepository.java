package codepractise.mvc.repository;

import codepractise.mvc.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void addProduct (Product product);
    Product getProductByID (String code);
    void removeProduct (Product product);
    void editProduct (Product product);
}
