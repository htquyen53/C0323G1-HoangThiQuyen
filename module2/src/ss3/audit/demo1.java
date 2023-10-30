package ss3.audit;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7,8,9};
        Integer[] arr2 = {1,3,5,7,9};
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapResult = new TreeMap<>();
        for (int num : arr1) {
            if (!mapResult.containsKey(num)) {
                mapResult.put(num, 1);
            } else {
                mapResult.put(num, mapResult.get(num) + 1);
            }
        }
        for (int num : arr2) {
            if (!mapResult.containsKey(num)) {
                mapResult.put(num, 1);
            } else {
                mapResult.put(num, mapResult.get(num) + 1);
            }
        }
        Set<Integer> keySet = mapResult.keySet();
        for (Integer key : keySet) {
            if(mapResult.get(key)!=1) {
                result.add(key);
            };
        }
        System.out.println("Những số trùng nhau của 2 mảng số nguyên là:");
        for (Integer num: result) {
            System.out.println( num );
        }
    }
}
