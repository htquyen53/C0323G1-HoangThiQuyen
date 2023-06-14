package thuat_toan_module2;

import java.util.*;

public class Exercise_8 {
    public static int countOccurrences(String s1, String s2) {
        String[] parentArr = s1.split(",");
        String[] childArr = s2.split(",");
        List<String> parentList = new ArrayList<>();
        Collections.addAll(parentList, parentArr);
        List<String> childList = new ArrayList<>();
        Collections.addAll(childList, childArr);
        Map<String, Integer> stringIntegerMap = new TreeMap<>();
        for (int i = 0; i < parentList.size(); i++) {
            for (int j = 0; j < childList.size(); j++) {
                if (parentList.get(i).equals(childList.get(j))) {
                    if (!stringIntegerMap.containsKey(parentList.get(i))) {
                        stringIntegerMap.put(parentList.get(i), 1);
                    } else
                        stringIntegerMap.put(parentList.get(i), stringIntegerMap.get(parentList.get(i)) + 1);
                }
                return 0;
            }
        }
        List<Integer> countList = new ArrayList<>();
        for (String key : stringIntegerMap.keySet()) {
            countList.add(stringIntegerMap.get(key));
        }
        int count = countList.get(0);
        for (int i = 1; i < countList.size(); i++) {
            if (count > countList.get(i)) {
                count = countList.get(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOccurrences("1,3,5,3,1,6,7", "1,9"));

    }
}
