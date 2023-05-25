package ss15.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rd = new Random(); // Khởi tạo một đối tượng Random
        Integer[] arr = new Integer[100]; // Khởi tạo  mảng chứa 100 phần tử số nguyên
        System.out.println("List of array elements: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter index of any element of input array: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Value of element has index"  + x + " is: " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You entered index out of array bound!");
        }
    }
}
