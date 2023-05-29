package bailamthem.codegym_management_system.model;

public class Student extends Person {
    private String className;
    private double score;

    public Student() {
    }

    public Student(String id, String name, String birthday, boolean gender, String className, double studentScore) {
        super(id, name, birthday, gender);
        this.className = className;
        this.score = studentScore;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Thông tin học viên {" + super.toString() +
                ", Tên lớp: '" + className + '\'' +
                ", Điểm: " + score +
                '}';
    }

    public String getInfoToCSV() {
        return getId() + "," + getName() + "," + getBirthday() + "," + isGender() + "," + getClassName() + "," + getScore();
    }
}
