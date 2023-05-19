package ss11.convert_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Decimal number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;
        Stack stack = new Stack();
        do {
            stack.push(number % 2);
            count++;
            number /= 2;
        }
        while (number != 0);

        for (int i = 0; i < count; i++) {
            System.out.print(stack.pop());
        }
    }
}
