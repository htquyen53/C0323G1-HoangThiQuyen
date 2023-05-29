package ss17.bai_tap.product_management.controller;

import ss17.bai_tap.product_management.service.ProductService;

import java.util.Scanner;

public class ProductController {
    ProductService productService = new ProductService();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        MENU_WHILE:
        do {
            System.out.println("----------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM-------------\n" +
                    "Chọn chức năng (theo số) để tiếp tục: \n" +
                    "1. Thêm sản phẩm \n" +
                    "2. Hiển thị danh sách sản phẩm \n" +
                    "3. Tìm kiếm thông tin sản phẩm \n" +
                    "4. Thoát \n" +
                    "Chọn chức năng: ");
            int choose;
            try {
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        productService.addProduct();
                        break;
                    case 2:
                        productService.displayProductList();
                        break;
                    case 3:
                        do {
                            System.out.println("Bạn muốn tìm kiếm theo tên hay theo mã sản phẩm? \n" +
                                    "1. Tên \n" +
                                    "2. Mã \n" +
                                    "0. Thoát!");
                            int option = 0;
                            try {
                                option = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Bạn nhập sai định dạng, mời nhập lại!");
                            } catch (Exception e) {
                                System.out.println("Error");
                            }
                            if (option == 1) {
                                productService.getProductByName();
                            } else if (option == 2) {
                                productService.getProductByID();
                            } else if (option == 0) {
                                break;
                            } else {
                                System.out.println("Bạn nhập sai chức năng, mời nhập lại!");
                            }
                        } while (true);
                        break;
                    case 4:
                        break MENU_WHILE;
                    default:
                        System.out.println("Bạn nhập sai chức năng, mời nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng, vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println("Error!");
            }
        } while (true);
    }
}
