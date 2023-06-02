package case_study.furama_resort.utils;

public class Validate {
    public static boolean checkEmployeeID(String id) {
        return id.matches("^(NV)-\\d{4}$");
    }
    public static boolean checkCustomerID(String id) {
        return id.matches("^(KH)-\\d{4}$");
    }

    public static boolean checkName(String name) {
        return name.matches("^([A-Z]([a-z]+)\\s)+$");
    }

    public static boolean checkBirthday (String birthday) {return birthday.matches("^[0-3][0-9]/(0[1-9]|1[0-2])/\\d{4}$");}
    public static boolean checkCitizenID(String citizenID) {
        return (citizenID.matches("^\\d{9}$") | citizenID.matches("^\\d{12}$"));
    }
    public static boolean checkNumberPhone (String numberPhone) {
        return numberPhone.matches("^0\\d{9}$");
    }
    public static boolean checkEmail (String email) {return email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");}

}
