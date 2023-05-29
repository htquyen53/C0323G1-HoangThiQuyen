package ss17.bai_tap.product_management.service;

import ss17.bai_tap.product_management.model.Product;
import ss17.bai_tap.product_management.repository.ProductRepository;
import ss17.bai_tap.product_management.common.controller.utils.PersonValidate;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductRepository productRepository = new ProductRepository();
    private static List<Product> productList;

    @Override
    public void displayProductList() {
        productList = productRepository.getAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void getProductByID() {
        System.out.println("Nhập mã sản phẩm: ");
        String id = "";
        try {
            id = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Product product = productRepository.getProductById(id);
        if (product == null) {
            System.out.println("Sản phẩm có mã " + id + " không tồn tại!");
        } else {
            System.out.println(product);
        }
    }

    @Override
    public void getProductByName() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = "";
        try {
            name = scanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Lỗi thực thi!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Product> products = productRepository.getProductByName(name);
        if (products == null) {
            System.out.println("Sản phẩm có tên " + name + " không có trong danh mục!");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void addProduct() {
        String id = "";
        do {
            System.out.println("Nhập mã sản phẩm cần thêm: ");
            try {
                id = scanner.nextLine();
                if (!PersonValidate.checkFormat(id)) {
                    throw new IllegalInputException("Vui lòng không nhập ký tự đặc biệt!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        Product product = productRepository.getProductById(id);
        String productName;
        if (product != null) {
            System.out.println("Mã sản phẩm đã tồn tại!");
        } else {
            try {
                System.out.println("Nhập tên sản phẩm: ");
                productName = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        float price;
        do {
            System.out.println("Nhập giá sản phẩm: ");
            try {
                price = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng, mời nhập lại!");
            }
        } while (true);
        String manufacturer;
        do {
            System.out.println("Nhập tên hãng sản xuất sản phẩm: ");
            try {
                manufacturer = scanner.nextLine();
                if (!PersonValidate.checkFormat(manufacturer)) {
                    throw new IllegalInputException("Không sử dụng ký tự đặc biệt!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
        String description;
        do {
            System.out.println("Nhập mô tả sản phẩm: ");
            try {
                description = scanner.nextLine();
                if (!PersonValidate.checkFormat(description)) {
                    throw new IllegalInputException("Không sử dụng ký tự đặc biệt!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (true);
        Product newProduct = new Product(id, productName, price, manufacturer, description);
        productRepository.addProduct(newProduct);
        System.out.println("Thêm mới thành công!");
    }
}


