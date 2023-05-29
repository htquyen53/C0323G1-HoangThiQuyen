package ss17.bai_tap.copy_binary_file;

import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private String birthday;
    private String address;

    public Student() {
    }

    public Student(int studentId, String studentName, String birthday, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
