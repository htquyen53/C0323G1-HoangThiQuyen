package ss15.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    private void caculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("x + y = " + a);
            System.out.println("x - y = " + b);
            System.out.println("x * y = " + c);
            System.out.println("x / y = " + d);
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of x: ");
        int x = scanner.nextInt();
        System.out.println("Enter value of y: ");
        int y = scanner.nextInt();
        CalculationExample calc  = new CalculationExample();
        calc.caculate(x,y);
    }
}

