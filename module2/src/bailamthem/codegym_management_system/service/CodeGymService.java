package bailamthem.codegym_management_system.service;

import bailamthem.codegym_management_system.model.Student;
import bailamthem.codegym_management_system.repository.CodeGymRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeGymService implements ICodeGymService {
    private CodeGymRepository codeGymRepository = new CodeGymRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayStudentList() {
        ArrayList<Student> studentList = codeGymRepository.getStudentList();
        for (Student student : studentList) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void addStudent() {
        System.out.println("Nhập mã học viên: ");
        String id = scanner.nextLine();
        Student student = codeGymRepository.getStudentById(id);
        if (student != null) {
            System.out.println("Mã học viên đã tồn tại!");
        } else {
            System.out.println("Nhập tên học viên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh: ");
            String birthday = scanner.nextLine();
            System.out.println("Nhập giới tính: ");
            boolean gender = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Nhập tên lớp: ");
            String nameClass = scanner.nextLine();
            System.out.println("Nhập điểm học viên: ");
            double score = Double.parseDouble(scanner.nextLine());
            Student newStudent = new Student(id, name, birthday, gender, nameClass, score);
            codeGymRepository.addStudent(newStudent);
        }
    }

    @Override
    public void deleteStudent() {
        System.out.println("Vui lòng nhập mã học sinh bạn muốn xóa: ");
        String id = scanner.nextLine();
        // Kiểm tra mã học viên có tồn tại không.
        Student student = codeGymRepository.getStudentById(id);
        if (student == null) {
            System.out.println("Mã học viên không tồn tại!");
        } else {
            System.out.println("Bạn muốn xóa học viên " + student.getStudentName() + "?");
            System.out.println("1. Xóa ");
            System.out.println("2. Không xóa. ");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                codeGymRepository.deleteStudent(student);
                System.out.println("Xóa thành công!");
            }
        }
    }
}
