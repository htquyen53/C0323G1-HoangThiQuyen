package ss13.longest_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = scanner.nextLine();
        LinkedList<Character> resultList = findLongestConsecutiveString(string);
        for (Character character : resultList) {
            System.out.print(character);
        }
    }
    //Tìm chuỗi liên tiếp có độ dài lớn  nhất!
    public static LinkedList<Character> findLongestConsecutiveString(String string) {
        LinkedList<Character> maxList = new LinkedList<>();
        LinkedList<Character> tempList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            tempList.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > tempList.getLast()) {
                    tempList.add(string.charAt(j));
                } else {
                    break;
                }
            }
            if (tempList.size() > maxList.size()) {
                maxList.clear();
                maxList.addAll(tempList);
            }
            tempList.clear();
        }
        return maxList;
    }
}
