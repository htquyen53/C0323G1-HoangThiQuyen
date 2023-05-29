package bailamthem.codegym_management_system.repository;

import bailamthem.codegym_management_system.common.ReadAndWriteFileCSV;
import bailamthem.codegym_management_system.model.Student;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGymRepository implements ICodeGymRepository {
    private static ArrayList<Student> studentList = new ArrayList<>();

    static {
        Student student1 = new Student("01", "Hoàng Thị Quyên", "05/03/1995", false, "C0323G1", 100);
        Student student2 = new Student("02", "Lê Huy", "01/01/1990", true, "C0323G1", 100);
        Student student3 = new Student("03", "Ngô Đình Quân", "02/02/1999", true, "C0323G1", 100);
        Student student4 = new Student("04", "Ngô Hữu Hoàng Nhật", "03/03/1997", true, "C0323G1", 100);
        Student student5 = new Student("05", "Đàm Thoại Tin", "04/04/1998", false, "C0323G1", 100);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
    }

    @Override
    public ArrayList<Student> getStudentList() {
        ReadAndWriteFileCSV.writeFile(studentList);
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentList = (ArrayList<Student>) ReadAndWriteFileCSV.readFile();
        studentList.add(student);
        ReadAndWriteFileCSV.writeFile(studentList);

    }

    @Override
    public boolean checkIdFormat(String id) {
        String patternId = "^T\\d{3}$";
        Pattern regex = Pattern.compile(patternId);
        Matcher matcher = regex.matcher(id);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkDateFormat(String date) {
        String pattern = "^\\d{2}/\\d{2}\\d{4}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(date);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkClassNameFormat(String className) {
        String patternClassName = "^[C]\\D{4}$";
        Pattern regex = Pattern.compile(patternClassName);
        Matcher matcher = regex.matcher(className);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getStudentById(String id) {
        studentList = (ArrayList<Student>) ReadAndWriteFileCSV.readFile();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        studentList = (ArrayList<Student>) ReadAndWriteFileCSV.readFile();
        studentList.remove(student);
        ReadAndWriteFileCSV.writeFile(studentList);
    }
}
