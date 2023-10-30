package ss3.audit;

import java.util.*;

public class RemovingDuplicateInString {
//    Thuật toán xử lý chuỗi: loại bỏ giá trị trùng lặp, đếm số xuất hiện của mỗi từ trong chuỗi.
    public static void main(String[] args) {
        String string = "Một Hai Ba Bốn Bốn Năm Năm Năm";
        String[] strArr = string.split(" ");
        Map<String, Integer> mapStr = new TreeMap<>();
        for (String key: strArr
             ) {
            if(!mapStr.containsKey(key)) {
                mapStr.put(key,1);
            } else {
                mapStr.put(key,mapStr.get(key)+1);
            }
        }
        Set<String> stringSet = new LinkedHashSet<>();
        for (int i = 0; i < strArr.length; i++) {
            stringSet.add(strArr[i]);
        }
        for (String s: stringSet
             ) {
            System.out.println(s);

        }
    }
}
