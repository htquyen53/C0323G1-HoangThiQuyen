package ThiThuatToan;

public class ve_hinh {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
            for (int j = 0; j < 10; j++) {
                if (i < j && j > 9 - i || i > j && j < 9 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }
}
