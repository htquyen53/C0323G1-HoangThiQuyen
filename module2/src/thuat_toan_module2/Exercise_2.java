package thuat_toan_module2;

import java.util.ArrayList;
import java.util.List;
// Cho hai xâu kí tự, tìm số lượng ký tự chung giữa chúng.
public class Exercise_2 {
    public static String removeCharAt(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1);
    }

    public static void commonCharacterCount(String s1, String s2) {
        int count = 0;
        List<Character> commonCharacters = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    count++;
                    commonCharacters.add(s1.charAt(i));
                    s2 = removeCharAt(s2, j);
                    break;
                }
            }
        }
        System.out.println("2 xâu có " + count + " ký tự chung là: " + commonCharacters);
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        commonCharacterCount(s1, s2);
//        System.out.println("Xâu 1 và 2 có " + commonCharacterCount(s1, s2) + " ký tự chung.");
    }
}
