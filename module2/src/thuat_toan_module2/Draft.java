package thuat_toan_module2;

import java.util.Scanner;

public class Draft {
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String s = scanner.nextLine();
        System.out.println(s);
        System.out.println(reverseString(s));
    }
}
