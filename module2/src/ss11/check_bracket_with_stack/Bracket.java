package ss11.check_bracket_with_stack;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> aStack = new Stack<Character>();
        Stack<Character> bStack = new Stack<Character>();
        Character sym;
        Character left;
        boolean flag = true;
        System.out.println("Nhập vào biểu thức cần kiểm tra: ");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                sym = (Character) string.charAt(i);
                aStack.push(sym);
            }
            if (string.charAt(i) == ')') {
                left = (Character) string.charAt(i);
                bStack.push(left);
            }
            if (aStack == null && bStack != null) {
                flag = false;
                break;
            }
        }
        if (aStack.size() != bStack.size()) {
            flag = false;
        }
        if (flag)
            System.out.println("WELL!!!!");
        else System.out.println("??????");
    }
}

