package thuat_toan_module2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise_6 {
//    Viết hàm truyền vào một chuỗi findChar(string)
//    Hàm trả về 1 mảng chứa các ký tự xuất hiện nhiều hơn 1 lần trong chuỗi. Nếu không có ký tự nào xuất hiện nhiều hơn 1 lần thì trả về mảng rỗng

    public static List<Character> findChar(String s) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            } else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            }
        }
        for (Character key : charMap.keySet()) {
            if (charMap.get(key) > 1) {
                charList.add(key);
            }
        }
        return charList;
    }

    public static void main(String[] args) {
        String s1 = "abcbdcef";
        String s2 = "abdcef";
        String s3 = "abdcef123d";
        System.out.println(findChar(s1));
        System.out.println(findChar(s2));
        System.out.println(findChar(s3));
    }
}