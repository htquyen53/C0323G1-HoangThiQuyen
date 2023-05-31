package case_study.furama_resort.model.human;

public class Employee extends Person {
    private String academicLevel;
    private String jobPosition;
    private Float salary;
    public Employee() {
    }

    public Employee(String academicLevel, String jobPosition, Float salary) {
        this.academicLevel = academicLevel;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public Employee(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email, String academicLevel, String jobPosition, Float salary) {
        super(id, name, birthday, gender, citizenID, numberPhone, email);
        this.academicLevel = academicLevel;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "academicLevel='" + academicLevel + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", salary=" + salary +
                '}';
    }
}
