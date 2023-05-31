package case_study.furama_resort.model.human;

public abstract class Person {
    private String id;
    private String name;
    private String birthday;
    private boolean gender;
    private String citizenID;
    private String numberPhone;
    private String email;

    public Person() {
    }

    public Person(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.citizenID = citizenID;
        this.numberPhone = numberPhone;
        this.email = email;
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

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", citizenID='" + citizenID + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
