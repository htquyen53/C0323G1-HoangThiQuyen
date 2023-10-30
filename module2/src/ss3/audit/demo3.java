package ss3.audit;

import javafx.scene.effect.SepiaTone;

import java.util.*;

public class demo3 {
    // Thuật toán xử lý mảng: loại bỏ giá trị trùng lặp, đếm số xuất hiện của mỗi từ trong mảng.
    public static void main(String[] args) {
        Integer[] arr = {1,3,4,5,6,6,9,2,4,1};
        Map<Integer, Integer> arrMap = new TreeMap<>();
        for (Integer num: arr
             ) {
            if(!arrMap.containsKey(num)) {
                arrMap.put(num,1);
            } else{ arrMap.put(num,arrMap.get(num)+1);}
        }
        // Loại bỏ giá trị trùng lặp
        Set<Integer> arrSet = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            arrSet.add(arr[i]);
        }
        System.out.println("Mảng mới sau khi loại bỏ giá trị trùng lặp là: " );
        List<Integer> result = new ArrayList<>(arrSet);
        System.out.println(result);
        for (Integer key: arrMap.keySet()) {
            System.out.println(key + " xuất hiện " + arrMap.get(key) +" lần");
        }
    }
}
