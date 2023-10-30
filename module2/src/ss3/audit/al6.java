package ss3.audit;

import java.util.Map;
import java.util.TreeMap;

public class al6 {
    // Cho một chuổi string nhập vào là các ký tự số la mã, convert thành số nguyên.
    public static void main(String[] args) {
        String s = "VIII";
        Map<Character, Integer> map = new TreeMap<>();
        Character[] romanArr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Integer[] inArr = {1,5,10,50,100, 500, 1000};
        for (int i = 0; i < romanArr.length; i++) {
            for (int j = 0; j < inArr.length; j++) {
                map.put(romanArr[i], inArr[j]);
            }
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = map.get(s.charAt(0));
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i-1));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        System.out.println(result);
    }
}
