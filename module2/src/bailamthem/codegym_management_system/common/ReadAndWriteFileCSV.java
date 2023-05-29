package bailamthem.codegym_management_system.common;

import bailamthem.codegym_management_system.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSV {
    private static final String STUDENT_LIST_PATH = "module2/src/bailamthem/codegym_management_system/data/students.csv";
    public static void writeFile(List<Student> studentList) {
        File file = new File(STUDENT_LIST_PATH);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < studentList.size(); i++) {
                bufferedWriter.write(studentList.get(i).getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        File file = new File(STUDENT_LIST_PATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentArr = line.split(",");
                Student student = new Student(studentArr[0], studentArr[1], studentArr[2],
                        Boolean.getBoolean(studentArr[3]), studentArr[4], Double.parseDouble(studentArr[5]));
                studentList.add(student);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return studentList;
    }
}
