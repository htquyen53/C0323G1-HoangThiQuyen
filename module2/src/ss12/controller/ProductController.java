package ss12.controller;

import ss12.service.ProductServive;

import java.util.Scanner;

public class ProductController {
    private static ProductServive productServive = new ProductServive();
    public static void showMenu(){
        Scanner scanner = new Scanner(System.in);
        MENU_WHILE: do {
            System.out.println("-----------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----------\n"+
                    "Chọn chức năng (theo số) để tiếp tục: \n" +
                    "1. Hiển thị danh sách sản phẩm \n" +
                    "2. Thêm sản phẩm \n" +
                    "3. Sửa thông tin sản phẩm \n" +
                    "4. Tìm kiếm sản phẩm theo tên \n" +
                    "5. Sắp xếp sản phẩm theo giá \n" +
                    "6. Thoát.\n" +
                    "Chọn chức năng: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    productServive.displayProductList();
                    break;
                case "2":
                    productServive.addProduct();
                    break;
                case "3":
                    productServive.editProduct();
                    break;
                case "4":
                    productServive.getProductByName();
                    break;
                case "5":
                    System.out.println("Bạn muốn  sắp xếp theo chiều nào? \n" +
                            "1. Tăng dần! \n" +
                            "2. Giảm dần");
                    int chooseSort = Integer.parseInt(scanner.nextLine());
                    if (chooseSort == 1) {
                        productServive.productSortUp();
                    } else if (chooseSort == 2) {
                        productServive.productSortDown();
                    } else {
                        System.out.println("Bạn nhập sai chức năng!");
                    }
                    break;
                case "6":
                    break MENU_WHILE;
                default:
                    System.out.println("Sai chức năng, vui lòng nhập lại!!!");
            }
        } while (true);
    }
}
