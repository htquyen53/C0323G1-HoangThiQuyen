package ss3.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeA;
        int[] arrayA;
        System.out.println("Enter length of arrayA:");
        sizeA = scanner.nextInt();
        arrayA = new int[sizeA];
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println("Enter the element " + (i + 1) + " of arrayA:");
            arrayA[i] = scanner.nextInt();
        }
        int sizeB;
        int[] arrayB;
        System.out.println("Enter length of arrayB:");
        sizeB = scanner.nextInt();
        arrayB = new int[sizeB];
        for (int i = 0; i < arrayB.length; i++) {
            System.out.println("Enter the element " + (i + 1) + " of arrayB:");
            arrayB[i] = scanner.nextInt();
        }
        int[] mergeArray = new int[sizeA + sizeB];
        int i = 0;
        while (i < arrayA.length) {
            mergeArray[i] = arrayA[i];
            i++;
        }
        while (i < mergeArray.length) {
            for (int k : arrayB) {
                mergeArray[i] = k;
                i++;
            }
        }
        System.out.println("ArrayA is: ");
        for (int j : arrayA) {
            System.out.print(j + "\t");
        }
        System.out.println("\nArrayB is: ");
        for (int j : arrayB) {
            System.out.print(j + "\t");
        }
        System.out.println("\nArrayC (= arrayA + arrayB) is:");
        for (int j : mergeArray) {
            System.out.print(j + "\t");
        }
    }
}
