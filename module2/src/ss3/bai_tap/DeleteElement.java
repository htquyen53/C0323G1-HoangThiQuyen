package ss3.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        size = scanner.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter array before change: ");
        for (int j : array) {
            System.out.print(j + "\t");
        }
        int indexDelete = 0;
        int count = 0;
        int elementX;
        System.out.println("\nEnter numberX: ");
        elementX = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementX) {
                indexDelete = i;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The element you want to delete does not exist in array!!!");
        } else {
            for (int j = indexDelete; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = 0;
            System.out.println("Enter array after change: ");
            for (int j : array) {
                System.out.print(j + "\t");
            }
        }
    }
}
