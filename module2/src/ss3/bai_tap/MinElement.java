package ss3.bai_tap;

import java.util.Scanner;

public class MinElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        System.out.println("Nhập kích thước mảng: ");
        size = Integer.parseInt(scanner.nextLine());
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Phần tử thứ " + i + ":");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng số nguyên đã khởi tạo là: ");
        for (int y : array) {
            System.out.println(y + "\t");
        }
        int minElement = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (minElement > array[i]) {
                minElement = array[i];
                minIndex = i;
            }
        }
        System.out.println("Giá trị nhỏ nhất mảng đã nhập là: " + minElement + " tại vị trí " + minIndex);
    }
}
