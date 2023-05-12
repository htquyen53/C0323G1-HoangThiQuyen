package ss2.bai_tap;

public class HienThiHinh {

    public static void main(String[] args) {
        System.out.println("Hình chữ nhật có chiều dài bằng 7 và chiều rộng bằng 3: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("Tam giác vuông cân có chiều cao = 7");
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("Tam giác vuông cân ngược có chiều cao = 7");
        for (int i = 7; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("In hình tam giác đều: ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                System.out.print(" ");
            }
            for (int t = 0; t < 2 * i + 1; t++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}

