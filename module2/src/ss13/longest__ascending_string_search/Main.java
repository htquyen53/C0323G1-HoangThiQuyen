package ss13.longest__ascending_string_search;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        System.out.println("String after sorting and have max length is: ");
        LinkedList<Character> result = stringSortUpMax(string);
        for (Character character : result) {
            System.out.print(character);
        }
    }
    // Xét lấy chuỗi ký tự tăng dần có độ dài lớn nhất
    public static LinkedList<Character> stringSortUpMax(String string) {
        LinkedList<Character> maxList = new LinkedList<>();
        LinkedList<Character> sortList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            sortList.add(string.charAt(i));
            for (int j = i+1; j < string.length(); j++) {
                if (string.charAt(j)>sortList.getLast()) {
                    sortList.add(string.charAt(j));
                }
            }
            if (sortList.size()>maxList.size()) {
                maxList.clear();
                maxList.addAll(sortList);
            }
            sortList.clear();
        }
        return maxList;
    }
}
