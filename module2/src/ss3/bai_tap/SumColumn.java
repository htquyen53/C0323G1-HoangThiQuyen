package ss3.bai_tap;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows;
        System.out.println("Nhập số dòng: ");
        rows = Integer.parseInt(scanner.nextLine());
        int columns;
        System.out.println("Nhập số cột: ");
        columns = Integer.parseInt(scanner.nextLine());
        float[][] array;
        array = new float[rows][columns];
        System.out.println("Khởi tạo mảng 2 chiều: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Nhập phần tử tại vị trí [" + i + "," + j + "]");
                array[i][j] = scanner.nextFloat();
            }
        }
        System.out.println("Hiển thị mảng 2 chiều số thực đã khởi tạo: ");
        for (float[] rowX : array) {
            for (float element : rowX) {
                System.out.print(element + "\t");
            }
            System.out.print("\n");
        }
        float sumOfColumnX = 0;
        int columnX;
        System.out.println("Nhập địa chỉ cột muốn tính tổng: ");
        columnX = scanner.nextInt();
        if (columnX < 0 || columnX >= array.length) {
            System.out.println("Số cột bạn nhập không tồn tại trong mảng này!");
        } else {
            for (float[] floats : array) {
                sumOfColumnX += floats[columnX];
            }
            System.out.println("Tổng cột thứ " + columnX + " là: " + sumOfColumnX);
        }
    }
}
