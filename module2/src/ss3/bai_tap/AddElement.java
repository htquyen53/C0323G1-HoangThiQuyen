package ss3.bai_tap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size: ");
        size = Integer.parseInt(scanner.nextLine());
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            array[i] = scanner.nextInt();
        }
        System.out.println("Array before add new element: ");
        for (int j : array) {
            System.out.print(j + "\t");
        }
        int[] coppyArrray;
        coppyArrray = new int[size];
        for (int i = 0; i < coppyArrray.length; i++) {
            coppyArrray[i] = array[i];
        }
        int index;
        index = scanner.nextInt();
        int numberX;
        numberX = scanner.nextInt();
        if (index <= -1 || index >= array.length - 1) {
            System.out.println("Can not add element in array");
        } else {
            array[index] = numberX;
            for (int i = index + 1; i < array.length; i++) {
                array[i] = coppyArrray[index];
                index++;
            }
        }
        System.out.println("Array after add new element: ");
        for (int j : array) {
            System.out.print(j + "\t");
        }
    }
}
