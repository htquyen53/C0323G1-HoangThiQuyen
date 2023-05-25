package ss12.controller;

import ss12.service.ProductServive;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController {
    private static ProductServive productServive = new ProductServive();

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        MENU_WHILE:
        do {
            System.out.println("-----------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----------\n" +
                    "Chọn chức năng (theo số) để tiếp tục: \n" +
                    "1. Hiển thị danh sách sản phẩm \n" +
                    "2. Thêm sản phẩm \n" +
                    "3. Sửa thông tin sản phẩm \n" +
                    "4. Tìm kiếm sản phẩm theo tên \n" +
                    "5. Sắp xếp sản phẩm theo giá \n" +
                    "6. Thoát.\n" +
                    "Chọn chức năng: ");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng! Mời nhập lại!");
            } catch (Exception e) {
                System.out.println("Error");
            }
            switch (choose) {
                case 1:
                    productServive.displayProductList();
                    break;
                case 2:
                    productServive.addProduct();
                    break;
                case 3:
                    productServive.editProduct();
                    break;
                case 4:
                    productServive.getProductByName();
                    break;
                case 5:
                    int chooseSort = 0;
                    do {
                        System.out.println("Bạn muốn  sắp xếp theo chiều nào? \n" +
                                "1. Tăng dần! \n" +
                                "2. Giảm dần");
                        try {
                            chooseSort = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Bạn nhập sai định dạng, mời nhập lại!");
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                        if (chooseSort == 1) {
                            productServive.productSortUp();
                        } else if (chooseSort == 2) {
                            productServive.productSortDown();
                        } else if (chooseSort == 0) {
                            break;
                        } else {
                            System.out.println("Bạn nhập sai chức năng!");
                        }
                    } while (true);
                    break;
                case 6:
                    break MENU_WHILE;
                case 0:
                    break;
                default:
                    System.out.println("Sai chức năng, vui lòng nhập lại!!!");
            }
        } while (true);
    }
}
