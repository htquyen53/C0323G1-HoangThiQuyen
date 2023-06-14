package thuat_toan_module2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise_1 {
//    Cho một mảng số nguyên Hãy kiểm tra xem tần số xuất hiện của
//    tất cả các số nguyên trong mảng có bằng nhau hay không
    public static boolean checkEqualFrequency(String str) {
        String[] arr = str.split(", ");
        Map<String, Integer> integerIntegerMap = new LinkedHashMap<>();
        for (String element : arr) {
            if (!integerIntegerMap.containsKey(element)) {
                integerIntegerMap.put(element, 1);
            } else {
                integerIntegerMap.put(element, integerIntegerMap.get(element) + 1);
            }
        }
        Integer rootNumber = integerIntegerMap.get(arr[0]);
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                if (!integerIntegerMap.get(arr[i]).equals(rootNumber)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = "1, 4, 23, 5, 4, 4, 6, 7, 122, 6, 3, 6, 4, 7, 11, 34, 12, 34, 122";
        String str2 = "1, 2, 2, 1";
        String str3 = "1, 2, 2, 3, 1, 3, 1, 3";
        String str4 = "4, 3, 2, 1, 4, 2, 3, 1";
        String str5 = "100";
        System.out.println(checkEqualFrequency(str1));
        System.out.println(checkEqualFrequency(str2));
        System.out.println(checkEqualFrequency(str3));
        System.out.println(checkEqualFrequency(str4));
        System.out.println(checkEqualFrequency(str5));
    }
}
