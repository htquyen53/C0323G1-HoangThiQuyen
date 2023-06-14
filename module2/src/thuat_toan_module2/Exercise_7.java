package thuat_toan_module2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_7 {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean checkPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            } return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Khởi tạo mảng 2 chiều: ");
        System.out.println(" - Nhập chiều dài mảng: ");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(" - Nhập chiều rộng mảng: ");
        int width = Integer.parseInt(scanner.nextLine());
        int[][] array2D = new int[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.println("Nhập phần tử: ");
                array2D[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        List<Integer> arrNum = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (!arrNum.contains(array2D[i][j]) && checkPrimeNumber(array2D[i][j])) {
                    arrNum.add(array2D[i][j]);
                }
            }
        }
        arrNum.sort((o1, o2) -> o1 - o2);
        System.out.println("Chuỗi các số nguyên tố được sắp xếp tăng dần là: " + arrNum);
    }
}
