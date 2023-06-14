package codepractise.mvc.controller;

import codepractise.mvc.service.IProductService;
import codepractise.mvc.service.ProductService;

import java.util.Scanner;

public class ProductController {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final IProductService PRODUCT_SERVICE = new ProductService();

    public static void displayMenu() {
        int choose;
        do {
            System.out.println("----------------QUẢN LÝ DANH MỤC SẢN PHẨM-----------------");
            System.out.println("Lựa chọn chức năng: ");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Chỉnh sửa thông tin sản phẩm");
            System.out.println("5. Thoát");
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
                switch (choose) {
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }

            } catch (NumberFormatException e) {
                System.err.println("Bạn nhập sai định dạng số!");
            } catch (Exception e) {
                System.err.println("Error");
            }
        } while (true);

    }
}
