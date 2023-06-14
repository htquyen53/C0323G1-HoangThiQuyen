package ss11.check_string_palindrome_with_queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra:");
        String string = scanner.nextLine();
        String[] stringArray = string.split("");
        Stack<String> stack = new Stack<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s : stringArray) {
            stack.push(s);
            queue.add(s);
        }
        boolean flag = true;
        for (int i = 0; i < stringArray.length; i++) {
            if (!Objects.equals(stack.pop(), queue.poll())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Đây là Palindrome!");
        } else {
            System.out.println("Đây không phải là Palindrome!");
        }
    }
}
