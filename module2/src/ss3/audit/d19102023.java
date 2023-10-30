package ss3.audit;

import java.util.Arrays;

public class d19102023 {
    public static void main(String[] args) {
        int[] numbers = {2,6,18,4};
        boolean allEven = Arrays.stream(numbers).allMatch(n -> n % 2 == 0);
        boolean allOdd = Arrays.stream(numbers).allMatch(n -> n % 2 == 1);
        if (allEven) {
            System.out.println("Chẵn");
        } else if (allOdd) {
            System.out.println("Lẻ");
        } else {
            System.out.println("Vừa chẵn lẻ");
        }


    }
}
