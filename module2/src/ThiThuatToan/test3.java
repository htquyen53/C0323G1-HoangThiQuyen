package ThiThuatToan;

import java.util.ArrayDeque;
import java.util.Scanner;

public class test3 {
    public static String[] solution(String s) {
        String[] arrayS = s.split("");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < arrayS.length; i++) {
            if (!arrayS[i + 1].equals(arrayS[i + 1].toUpperCase())) {
                queue.add(arrayS[i].toLowerCase());
            } else {
                queue.add(arrayS[i].toLowerCase());
                queue.add(" ");
            }
        }
        String[] arrResult = new String[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            arrResult[i] = queue.pop();
        }
        return  arrResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String s = scanner.nextLine();
        String[] result = solution(s);
        for (String e : result) {
            System.out.print(e);
        }
    }
}
