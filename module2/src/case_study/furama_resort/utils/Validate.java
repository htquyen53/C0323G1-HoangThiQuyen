package case_study.furama_resort.utils;

public class Validate {
    public static boolean checkEmployeeID(String id) {
        return id.matches("^(NV)-\\d{4}$");
    }

    public static boolean checkCustomerID(String id) {
        return id.matches("^(KH)-\\d{4}$");
    }

    public static boolean checkVillaID(String id) {
        return id.matches("^(SVVL)-\\d{4}$");
    }

    public static boolean checkHouseID(String id) {
        return id.matches("^(SVHO)-\\d{4}$");
    }

    public static boolean checkRoomID(String id) {
        return id.matches("^(SVRO)-\\d{4}$");
    }
    public static boolean checkBookingID(String id) { return id.matches("^(BOK-\\d{4})$");}

    public static boolean checkFacility(String facility) {
        return facility.matches("^([A-Z]([a-z]+)\\s)+[A-Z]([a-z]+)$");
    }

    public static boolean checkName(String name) {
        return name.matches("^([A-Z]([a-z]+)\\s)+([A-Z]([a-z]+))$");
    }

    public static boolean checkDate(String date) {
        return date.matches("^[0-3][0-9]/(0[1-9]|1[0-2])/\\d{4}$");
    }

    public static boolean checkCitizenID(String citizenID) {
        return (citizenID.matches("^\\d{9}$") | citizenID.matches("^\\d{12}$"));
    }

    public static boolean checkNumberPhone(String numberPhone) {
        return numberPhone.matches("^0\\d{9}$");
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
    }
    public static boolean checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) > 32 && (int) input.charAt(i) <= 64 ||
                    (int) input.charAt(i) >= 91 && (int) input.charAt(i) <= 96 ||
                    (int) input.charAt(i) >= 123 && (int) input.charAt(i) <= 126) {
                return false;
            }
        }
        return true;
    }
}
