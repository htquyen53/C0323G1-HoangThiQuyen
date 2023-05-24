package ss14;

import java.util.Scanner;

public class InsertSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list size: "); // Nhập kích thước mảng số nguyên truyền vào
        int size = Integer.parseInt(scanner.nextLine());
        int[] list = new int[size]; // Khởi tạo mảng số nguyên với kích thước đã nhập
        System.out.println("Enter " + size + " values: ");
        for (int i = 0; i < list.length; i++) { // Nhập giá trị phần tử trong mảng
            list[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Your input list: "); // Hiển thị mảng trước khi sắp xếp
        for (int element : list) {
            System.out.print(element + "\t");
        }
        int pos; // Khai báo biến pos là vị trí phần tử được chọn để lấy ra
        int elementX; // Khai báo biến elementX là giá trị phần tử tại vị trí pos
        for (int i = 1; i < list.length; i++) { //  Tiến hành sắp xếp
            elementX = list[i]; // Lấy ra giá trị tại vị trị trí i gán cho elementX
            pos = i;            // Gán pos = vị trí index của phần tử được lấy ra
            while (pos > 0 && elementX < list[pos - 1]) { //Khi element X nhỏ hơn giá trị của phần tử phía trước
                list[pos] = list[pos - 1]; // Đổi chỗ elementX với phần ử trước đó
                pos--;
            }
            list[pos] = elementX; // nếu không thỏa mãn điều kiện trong while, vị trí phần tử không thay đổi
        }
        System.out.println("Your output list: "); // Hiển thị mảng sau khi sắp xếp
        for (int element : list) {
            System.out.print(element + "\t");
        }
    }
}


