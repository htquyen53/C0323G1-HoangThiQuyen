package ss11.deverse_array_with_stack;

import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mảng số nguyên trước khi đảo ngược: ");
        System.out.println("Nhập độ dài: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ " + i + ":");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng số nguyên đã nhập: ");
        for (int y : array) {
            System.out.print(y + "\t");
            stack.push(y);
        }
        System.out.println("\n" + "Mảng số nguyên sau khi đảo ngược: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
            System.out.print(array[i] + "\t");
        }
    }
}
