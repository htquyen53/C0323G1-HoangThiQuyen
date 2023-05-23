package ss11.count_word_by_map;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        String string = scanner.nextLine().toLowerCase();
        Map<String, Integer> mapWord = new TreeMap<>();
        String[] arrString = string.split(" ");
        for (String s : arrString) {
            if (!mapWord.containsKey(s)) {
                mapWord.put((s), 1);
            } else {
                mapWord.put((s), mapWord.get(s) + 1);
            }
        }
        Set<String> keySet = mapWord.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + mapWord.get(key));
        }
    }
}
