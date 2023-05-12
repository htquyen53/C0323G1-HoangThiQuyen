package ss2.bai_tap;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int numberCheck = 2;
        System.out.println("Enter the number of prime number you want to display: ");
        int numbers = Integer.parseInt(scanner.nextLine());
        int countCheck;
        while (count < numbers) {
            countCheck = 0;
            for (int i = 2; i <= numberCheck; i++) {
                if (numberCheck % i == 0) {
                    countCheck++;
                }
            }
            if (countCheck == 1) {
                System.out.println(numberCheck);
                count++;
            }
            numberCheck++;
        }
    }
}

