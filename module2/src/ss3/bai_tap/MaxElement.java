package ss3.bai_tap;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kích thước ma trận ");
        System.out.println("Nhập số dòng: ");
        int width = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số cột: ");
        int height = Integer.parseInt(scanner.nextLine());
        float[][] matrix = new float[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println("Nhập phần tử tại địa chỉ [" + i + ", " + j + "]");
                matrix[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
        System.out.println("Ma trận đã khởi tạo là: ");
        for (float[] rows : matrix) {
            for (float aRow : rows) {
                System.out.print(aRow + "\t");
            }
            System.out.println("\n");
        }
        float maxElement = matrix[0][0];
        int maxIndexRow = 0;
        int maxIndexCol = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxElement < matrix[i][j]) {
                    maxElement = matrix[i][j];
                    maxIndexRow = i;
                    maxIndexCol = j;
                }
            }
        }
        System.out.println("Phần tử lớn nhất của mảng 2 chiều đã nhập là: " + maxElement +
                " tại vị trí [" + maxIndexRow + "][" + maxIndexCol + "]");
    }
}
