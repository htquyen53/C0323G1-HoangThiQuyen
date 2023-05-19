package ss11.deverse_array_with_stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class WStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> wstack = new Stack<>();
        System.out.println("Nhập chuỗi đầu vào: ");
        String string = scanner.nextLine();
        System.out.println(string);
        String[] arrString = string.split(" ");
        for (String mWord : arrString) {
            wstack.push(mWord);
        }
        System.out.println("Chuỗi sao khi đảo ngược: ");
        for (int i = 0; i < arrString.length; i++) {
            arrString[i] = wstack.pop();
            System.out.print(arrString[i] + " ");
        }
    }
}
