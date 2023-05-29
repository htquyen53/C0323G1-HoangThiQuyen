package ss12.utils;

public class ProductValidate {

    public static boolean checkId(String id) {
        for (int i = 0; i < id.length(); i++) {
            if ((int) id.charAt(i) >= 32 && (int) id.charAt(i) <= 47 ||
                    (int) id.charAt(i) >= 58 && (int) id.charAt(i) <=64) {
                return false;
            }
        }
        return true;
    }
}
