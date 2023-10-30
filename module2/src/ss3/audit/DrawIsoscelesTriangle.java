package ss3.audit;

public class DrawIsoscelesTriangle {
    public static void main(String[] args) {
        drawIsoscelesTriable(7);
    }

    public static void drawIsoscelesTriable(int width) {
        for (int i = 0; i <= width; i++) {
            for (int j = width - 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int t = 1; t <= i * 2 - 1; t++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
