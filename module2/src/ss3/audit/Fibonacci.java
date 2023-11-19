package ss3.audit;

public class Fibonacci {
    // Display the fibonacci sequence less than 100
    public static void main(String[] args) {
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        while (sum < 100) {
            System.out.print(sum + " ");
            n1 = n2;
            n2 = sum;
            sum = n1 + n2;
        }
    }
}
