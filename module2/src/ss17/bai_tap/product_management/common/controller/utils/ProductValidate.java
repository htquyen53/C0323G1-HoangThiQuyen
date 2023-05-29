package ss17.bai_tap.product_management.common.controller.utils;

public class ProductValidate {

    public static boolean checkFormat(String string) {
        for (int i = 0; i < string.length(); i++) {
            if ((int) string.charAt(i) >= 32 && (int) string.charAt(i) <= 47 ||
                    (int) string.charAt(i) >= 58 && (int) string.charAt(i) <= 64) {
                return false;
            }
        }
        return true;
    }
}
