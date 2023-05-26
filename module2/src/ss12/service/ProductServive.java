package ss12.service;

import ss12.model.Product;
import ss12.repository.ProductRepository;
import ss12.utils.ProductValidate;
import ss15.bai_tap.triangle.IllegalTriangleException;

import java.util.List;
import java.util.Scanner;

public class ProductServive implements IProductService {
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
    public void addProduct() {
        //Product(String id, String productName, String productOrigin, int quantity, String description, float price)
        String id = "";
        do {
            System.out.println("Nhập mã sản phẩm cần thêm: ");
            try {
                id = scanner.nextLine();
                if(!ProductValidate.checkId(id)) {
                    throw new IllegalInputException("Vui lòng không nhập ký tự đặc biệt. Mời nhập lại!");
                }
                break;
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        Product product = productRepository.getProductById(id);
        if (product != null) {
            System.out.println("Mã sản phẩm đã tồn tại");
        } else {
            System.out.println("Nhập tên sản phẩm: ");
            String nameProduct = scanner.nextLine();
            System.out.println("Nhập xuất xứ sản phẩm: ");
            String productOrigin = scanner.nextLine();
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập mô tả: ");
            String description = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            float price = Float.parseFloat(scanner.nextLine());
            Product newProduct = new Product(id, nameProduct, productOrigin, quantity, description, price);
            productRepository.addProduct(newProduct);
            System.out.println("Thêm mới thành công!");
        }
    }

    @Override
    public void removeProduct() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        Product product = productRepository.getProductById(id);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại!");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa sản phẩm " + product + "?");
            System.out.println("1. Xóa. ");
            System.out.println("2. Không xóa. ");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                productRepository.removeProduct(product);
                System.out.println("Xóa thành công!");
            }
        }
    }

    @Override
    public void getProductByName() {
        System.out.println("Nhập tên sản phẩm ");
        String name = scanner.nextLine();
        List<Product> resultList = productRepository.getProductByName(name);
        if (resultList == null) {
            System.out.println("Sản phẩm có tên " + name + " không tồn tại!");
        } else {
            for (Product product : resultList) {
                System.out.println(product);
            }
        }
    }

    public void editProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần chỉnh sửa: ");
        String id = scanner.nextLine();
        Product editProduct = productRepository.getProductById(id);
        if (editProduct == null) {
            System.out.println("Sản phẩm không tồn tại!");
        } else {
            System.out.println("Bạn muốn chỉnh sửa thông tin nào của sản phẩm? \n" +
                    "1. Tên sản phẩm \n" +
                    "2. Xuất xử sản phẩm \n" +
                    "3. Số lượng sản phẩm \n" +
                    "4. Mô tả sản phẩm \n" +
                    "5. Giá sản phẩm \n" +
                    "6. Thoát ");
            EDIT_PRODUCT:
            do {
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        System.out.println("Nhập tên mới: ");
                        String name = scanner.nextLine();
                        editProduct.setProductName(name);
                        System.out.println("Chỉnh sửa thành công!");
                        break;
                    case "2":
                        System.out.println("Nhập xuất xứ: ");
                        String origin = scanner.nextLine();
                        editProduct.setProductOrigin(origin);
                        System.out.println("Chỉnh sửa thành công!");
                        break;
                    case "3":
                        System.out.println("Nhập số lượng mới:");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        editProduct.setQuantity(quantity);
                        System.out.println("Chỉnh sửa thành công!");
                        break;
                    case "4":
                        System.out.println("Nhập mô tả mới: ");
                        String description = scanner.nextLine();
                        editProduct.setDescription(description);
                        System.out.println("Chỉnh sửa thành công!");
                        break;
                    case "5":
                        System.out.println("Nhập giá mới: ");
                        float price = Float.parseFloat(scanner.nextLine());
                        editProduct.setPrice(price);
                        System.out.println("Chỉnh sửa thành công!");
                        break;
                    case "6":
                        break EDIT_PRODUCT;
                    default:
                        System.out.println("Bạn đã nhập sai chức năng!");
                }
            } while (true);
        }
    }

    @Override
    public void productSortUp() {
        productRepository.productSortUp();
        displayProductList();
    }

    @Override
    public void productSortDown() {
        productRepository.productSortDown();
        displayProductList();
    }
}
