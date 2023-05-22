package ss12.service;

import ss12.model.Product;

public interface IProductService {
   void displayProductList();
   void addProduct();
   void removeProduct();
   void editProduct ();
   void getProductByName();
   void productSortUp();
   void productSortDown();
}
