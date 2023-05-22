package bailamthem.codegym_management_system.repository;

import bailamthem.codegym_management_system.model.Student;

import java.util.ArrayList;

public interface ICodeGymRepository {
    ArrayList<Student> getStudentList() ;
    void addStudent(Student student);
    Student getStudentById(String id);
    void deleteStudent(Student student);
}
