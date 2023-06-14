package codepractise.mvc.service;

import codepractise.mvc.model.Product;
import codepractise.mvc.repository.IProductRepository;
import codepractise.mvc.repository.ProductRepository;
import codepractise.mvc.utils.IllegalInputException;
import codepractise.mvc.utils.Validate;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final IProductRepository PRODUCT_REPOSITORY = new ProductRepository();
    @Override
    public void displayAll() {
        List<Product> productList = PRODUCT_REPOSITORY.getAll();
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    @Override
    public void addProduct() {
        do {
            System.out.println("Nhập mã sản phẩm: ");
            String code;
            try {
                code = SCANNER.nextLine();
                if (!Validate.checkID(code)) {
                    throw new IllegalInputException("Bạn nhập sai định dạng mã id, mời nhập lại!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);


    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void editProduct() {

    }
}
