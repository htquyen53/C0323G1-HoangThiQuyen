package ss3.bai_tap;

import java.util.Scanner;

public class SumMatrixDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] squareMatrix;
        int size;
        System.out.println("Nhập kích thước ma trận vuông: ");
        size = Integer.parseInt(scanner.nextLine());
        squareMatrix = new float[size][size];
        System.out.println("Khởi tạo ma trận!");
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                System.out.println("Nhập phần từ tại ô địa chỉ [" + i + ", " + j + "]");
                squareMatrix[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
        System.out.println("Hiển thị ma trận đã khởi tạo: ");
        for (float[] row : squareMatrix) {
            for (float element : row) {
                System.out.print(element + "\t");
            }
            System.out.println("\n");
        }
        float sumMatrixDiagonal = 0;
        for (int i = 0; i < squareMatrix.length; i++) {
            sumMatrixDiagonal += squareMatrix[i][i];
        }
        System.out.println("Tổng các số ở đường chéo chính của ma trận vuông là: " + sumMatrixDiagonal);
    }
}
