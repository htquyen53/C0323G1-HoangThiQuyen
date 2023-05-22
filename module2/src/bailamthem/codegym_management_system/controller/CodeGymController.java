package bailamthem.codegym_management_system.controller;

import bailamthem.codegym_management_system.service.CodeGymService;

import java.util.Scanner;

public class CodeGymController {
    CodeGymService  codeGymService = new CodeGymService();
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        MENU_WHILE:
        do {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN CODEGYM----- \n" +
                    "Chọn chức năng (theo số) để tiếp tục: \n" +
                    "1. Thêm mới học sinh \n" +
                    "2. Xóa học sinh \n" +
                    "3. Xem danh sách học sinh \n" +
                    "4. Thoát \n" +
                    "Chọn chức năng: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    codeGymService.addStudent();
                    break;
                case "2":
                    codeGymService.deleteStudent();
                    break;
                case "3":
                    codeGymService.displayStudentList();
                    break ;
                case  "4":
                    break MENU_WHILE;
                default:
                    System.out.println("Sai chức năng, vui lòng nhập lại!!!!");
            }
        } while (true);
    }
}
