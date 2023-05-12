package ss2.bai_tap;

public class PrimeNumberLess100 {
    public static void main(String[] args) {
        System.out.println("Hiện thị các số nguyên tố bé hơn 100:");
        int countCheck;
        for (int i = 2; i < 100; i++) {
            countCheck = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    countCheck++;
                }
            }
            if (countCheck == 1) {
                System.out.println(i);
            }
        }
    }
}
