package bailamthem.codegym_management_system.repository;

import bailamthem.codegym_management_system.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface ICodeGymRepository {
    List<Student> getStudentList() ;
    void addStudent(Student student);
    Student getStudentById(String id);
    void deleteStudent(Student student);
    boolean checkIdFormat (String id);
    boolean checkDateFormat (String date);
    boolean checkClassNameFormat (String className);

}
