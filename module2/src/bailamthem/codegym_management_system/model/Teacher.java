package bailamthem.codegym_management_system.model;

public class Teacher extends Person {
    private String subject;

    public  Teacher() {
    }
    public Teacher(String id, String name, String birthday, boolean gender, String subject) {
        super(id, name, birthday, gender);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Giảng viên {"+ super.toString() + ", chuyên môn: " + subject + "\'" + "}";
    }
    public String getInfoToCSV() {
        return getId() + ", " + getName() + ", " + getBirthday() + ", " + isGender() + ", " + getSubject();
    }
}
