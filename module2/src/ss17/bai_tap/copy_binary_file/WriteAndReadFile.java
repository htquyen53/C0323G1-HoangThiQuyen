package ss17.bai_tap.copy_binary_file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    private static final String STUDENT_LIST_PATH = "module2/src/ss17/bai_tap/copy_binary_file/students.dat";

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(01,"Hoàng Quyên", "01/01/2000","Hải Châu, Đà Nẵng"));
        studentList.add(new Student(02,"Nguyễn An", "11/02/2000","Sơn Trà, Đà Nẵng"));
        studentList.add(new Student(03,"Đỗ Minh Tâm", "04/04/2000","Thanh Khê, Đà Nẵng"));
        studentList.add(new Student(04,"Bùi Anh", "10/10/2000","Ngũ Hành Sơn, Đà Nẵng"));
        writeStudentListToFile(studentList,STUDENT_LIST_PATH);
        List<Student> studentListFromFile = readStudentListFromFile(STUDENT_LIST_PATH);
        for (Student student: studentListFromFile) {
            System.out.println(student);
        }
    }
    public static void writeStudentListToFile (List<Student>studentList, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> readStudentListFromFile (String path) {
        List<Student> studentList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}
