package ss13.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Bước 1: Tạo mảng bất kỳ.
        int[] array = {1, 5, 2, 3, 6, 7, 23, 67, 11, 10, 9};
        //Bước 2: sắp xếp theo thứ tự từ bé đến lớn.
        Arrays.sort(array);
        System.out.println("Nhập giá trị cần tìm kiếm!");
        int value = Integer.parseInt(scanner.nextLine());
        int index = binarySearch(array, 0, array.length - 1, value);
        if (index == -1) {
            System.out.println("Giá trị không tồn tại trong chuỗi");
        } else {
            System.out.println("Giá trị tồn tại trong chuỗi!");
        }
    }

    //Bước 3: Khai báo hàm binarySearch(int[] array, int left, int right ,int value).
    public static int binarySearch(int[] array, int left, int right, int value) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
