package ss19.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneValidate {
    public static boolean checkNumberPhone (String numberPhone) {
        String numberPhoneRegex = "^[(]\\d{2}[)]-[(]0\\d{9}[)]$";
        Pattern pattern = Pattern.compile(numberPhoneRegex);
        Matcher matcher = pattern.matcher(numberPhone);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("Nhập số điện thoại: ");
        Scanner scanner = new Scanner(System.in);
        String numberPhone1 = scanner.nextLine();
        if (checkNumberPhone(numberPhone1)) {
            System.out.println("Số điện thoại hợp lệ!");
        } else {
            System.out.println("Số điện thoại không hợp lệ!");
        }
    }
}
