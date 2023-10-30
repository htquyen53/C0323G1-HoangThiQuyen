package ss3.audit;
// Cho 5 số tự nhiên, tìm tổng 4 số lớn nhất và nhỏ nhất của mảng đó, dùng 1 vòng for.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo5 {
    public static void main(String[] args) {
        Integer[] inputArr = {1,2,4,3,5};
        List<Integer> arrList = new ArrayList<>(Arrays.asList(inputArr));
        Collections.sort(arrList);
        Integer sumMax = 0;
        Integer sumMin = 0;
        for (int i = 0; i < arrList.size(); i++) {
            if(i>0) {
                sumMax += arrList.get(i);
            }
            if (i<arrList.size()-1) {
                sumMin+= arrList.get(i);
            }
        }
        System.out.println(arrList);
        System.out.println(sumMax);
        System.out.println(sumMin);
    }
}
