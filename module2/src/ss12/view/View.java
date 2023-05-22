package ss12.view;

import ss12.controller.ProductController;
import ss12.service.ProductServive;

public class View {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.showMenu();
    }
}
