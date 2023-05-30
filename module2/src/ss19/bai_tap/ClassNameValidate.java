package ss19.bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameValidate {
    public static boolean checkClassNameValidate(String s) {
        String classNameRegex = "^[CAP]\\d{4}[GHIK]$";
        Pattern pattern = Pattern.compile(classNameRegex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên lớp!");
        String className = scanner.nextLine();
        boolean result = checkClassNameValidate(className);
        System.out.println(result);
    }
}
