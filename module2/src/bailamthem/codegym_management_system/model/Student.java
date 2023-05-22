package bailamthem.codegym_management_system.model;

public class Student {
    private String studentID;
    private String studentName;
    private String studentBirthday;
    private boolean gender;
    private String className;
    private double studentScore;

    public Student() {
    }

    public Student(String studentID, String studentName, String studentBirthday, boolean gender, String className, double studentScore) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentBirthday = studentBirthday;
        this.gender = gender;
        this.className = className;
        this.studentScore = studentScore;
    }

    public String getStudentID() {return studentID; }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(String studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    @Override
    public String toString() {
        return "Thông tin học viên {" +
                "Mã học viên: " + studentID +
                ", Tên học viên: '" + studentName + '\'' +
                ", Ngày sinh: '" + studentBirthday + '\'' +
                ", Giới tính: " + gender +
                ", Tên lớp: '" + className + '\'' +
                ", Điểm: " + studentScore +
                '}';
    }
}
