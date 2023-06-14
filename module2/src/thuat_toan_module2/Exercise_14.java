package thuat_toan_module2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercise_14 {
    public static int countCharacter (String s) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            characterSet.add(s.charAt(i));
        } return characterSet.size();
    }

    public static void main(String[] args) {
        System.out.println("Số ký tự khác nhau của chuỗi đầu vào là: " + countCharacter("cabca"));
        System.out.println("Số ký tự khác nhau của chuỗi đầu vào là: " + countCharacter("ccccccccccccc"));
        System.out.println("Số ký tự khác nhau của chuỗi đầu vào là: " + countCharacter("cabcde"));
    }
}
