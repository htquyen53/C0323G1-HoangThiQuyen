package ss3.audit;

public class Fibonanci {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 0 || i == 1 || i == (i - 1) + (i - 2)) {
                System.out.print(i + " ");
            }
        }
    }
}
