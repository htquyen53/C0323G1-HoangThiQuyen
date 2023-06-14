package codepractise.mvc.utils;

public class Validate {
    public static boolean checkID (String id) {
        return id.matches("^(PR)-\\d{3}$");
    }
}
