package ss17.bai_tap.product_management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidate {
    public boolean checkIdFormat(String id) {
        String idRegex = "^\\d{2}\\w$";
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
    public boolean checkPriceFormat (Float price) {
        String priceRegex = "^\\d{3,8}.\\d{1}$";
        String pr = price.toString();
        Pattern pattern = Pattern.compile(priceRegex);
        Matcher matcher = pattern.matcher(pr);
        return matcher.matches();

    }
    public boolean checkInput(String input) {
        for (int i = 0; i <= input.length() - 1; i++) {
            if ((int) input.charAt(i) > 32 && (int) input.charAt(i) <= 47 ||
                    (int) input.charAt(i) >= 58 && (int) input.charAt(i) <= 64) {
                return false;
            }
        }
        return true;
    }
}
