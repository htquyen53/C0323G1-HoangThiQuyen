package bailamthem.codegym_management_system.service;

import bailamthem.codegym_management_system.model.Student;
import bailamthem.codegym_management_system.repository.CodeGymRepository;
import bailamthem.codegym_management_system.utils.IllegalInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeGymService implements ICodeGymService {
    private CodeGymRepository codeGymRepository = new CodeGymRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayStudentList() {
        ArrayList<Student> productList = codeGymRepository.getStudentList();
        for (Student product : productList) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }

    public static boolean checkId(String id) {
        for (int i = 0; i < id.length(); i++) {
            if ((int) id.charAt(i) >= 32 && (int) id.charAt(i) <= 47 ||
                    (int) id.charAt(i) >= 58 && (int) id.charAt(i) <= 64) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addStudent() {
        System.out.println("Nhập mã học viên: ");
        String id = "";
        try {
            id = scanner.nextLine();
            if (!checkId(id)) {
                throw new IllegalInputException("Vui lòng không nhập ký tự đặc biệt!");
            }
        } catch (IllegalInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Student product = codeGymRepository.getStudentById(id);
        if (product != null) {
            System.out.println("Mã học viên đã tồn tại!");
        } else {
            String name;
            do {
                System.out.println("Nhập tên học viên: ");
                try {
                    name = scanner.nextLine();
                    if (name.trim().isEmpty()) {
                        throw new RuntimeException("Không để trống tên!");
                    }
                    break;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (true);
            String birthday;
            do {
                System.out.println("Nhập ngày sinh: ");
                try {
                    birthday = scanner.nextLine();
                    if (!codeGymRepository.checkDateFormat(birthday)) {
                        throw new IllegalInputException("Vui lòng nhập đúng định dạng dd/mm/yyyy");
                    }
                    break;
                } catch (IllegalInputException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);

            System.out.println("Nhập giới tính: ");
            boolean gender = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Nhập tên lớp: ");
            String nameClass = scanner.nextLine();
            System.out.println("Nhập điểm học viên: ");
            double score = Double.parseDouble(scanner.nextLine());
            Student newProduct = new Student(id, name, birthday, gender, nameClass, score);
            codeGymRepository.addStudent(newProduct);
        }
    }

    @Override
    public void deleteStudent() {
        System.out.println("Vui lòng nhập mã học sinh bạn muốn xóa: ");
        String id = scanner.nextLine();
        // Kiểm tra mã học viên có tồn tại không.
        Student product = codeGymRepository.getStudentById(id);
        if (product == null) {
            System.out.println("Mã học viên không tồn tại!");
        } else {
            System.out.println("Bạn muốn xóa học viên " + product.getName() + "?");
            System.out.println("1. Xóa ");
            System.out.println("2. Không xóa. ");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                codeGymRepository.deleteStudent(product);
                System.out.println("Xóa thành công!");
            }
        }
    }
}
