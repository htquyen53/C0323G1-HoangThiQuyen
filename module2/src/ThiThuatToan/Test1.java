package ThiThuatToan;

public class Test1 {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(i);
            }
            System.out.println("\n");
        }
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(i);
            }
            System.out.println("\n");
        }
    }
}
