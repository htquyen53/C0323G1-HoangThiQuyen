package bailamthem.codegym_management_system.model;

public class Person {
    private String id;
    private String name;
    private String birthday;
    private boolean gender;

    public Person() {
    }

    public Person(String id, String name, String birthday, boolean gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Mã số: " + id + '\'' +
                ", Họ và tên: " + name + '\'' +
                ", Ngày sinh: " + birthday + '\'' +
                ", Giới tính: "  + (gender? "Nam" : "Nữ");
    }

}
