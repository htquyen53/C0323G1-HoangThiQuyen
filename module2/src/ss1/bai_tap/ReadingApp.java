package ss1.bai_tap;

import java.util.Scanner;

public class ReadingApp {
    public static void main(String[] args) {
        System.out.println("Bạn muốn đọc số nào? ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arrayA = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arrayB = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if (number < 10) {
            for (int i = 0; i < arrayA.length; i++) {
                if (number == arrayA[i]) {
                    System.out.println(arrayB[i]);
                    break;
                }
            }
        } else if (number < 20) {
            String input = Integer.toString(number);
            int unit = Integer.parseInt(String.valueOf(input.charAt(1)));
            switch (unit) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                default:
                    for (int i = 1; i < arrayA.length; i++) {
                        if (unit == arrayA[i]) {
                            System.out.println(arrayB[i] + "teen");
                            break;
                        }
                    }
            }
        } else if (number < 100) {
            int[] dozenArray = new int[2];
            String number2X = Integer.toString(number);
            dozenArray[0] = Integer.parseInt(String.valueOf(number2X.charAt(0)));
            dozenArray[1] = Integer.parseInt(String.valueOf(number2X.charAt(1)));
            switch (dozenArray[0]) {
                case 2:
                    System.out.print("twenty");
                    break;
                case 3:
                    System.out.print("thirty");
                    break;
                case 5:
                    System.out.print("fifty");
                    break;
                default:
                    for (int i = 1; i < arrayA.length; i++) {
                        if (dozenArray[0] == arrayA[i]) {
                            System.out.print(arrayB[i] + "ty");
                            break;
                        }
                    }
            }
            for (int i = 1; i < arrayA.length; i++) {
                if (dozenArray[1] == arrayA[i]) {
                    System.out.println("-" + arrayB[i]);
                }
            }

        } else if (number < 1000) {
            int[] array3X = new int[3];
            String number3X = Integer.toString(number);
            array3X[0] = Integer.parseInt(String.valueOf(number3X.charAt(0)));
            array3X[1] = Integer.parseInt(String.valueOf(number3X.charAt(1)));
            array3X[2] = Integer.parseInt(String.valueOf(number3X.charAt(2)));
            for (int i = 1; i < arrayA.length; i++) {
                if (array3X[0] == arrayA[i]) {
                    System.out.print(arrayB[i] + " hundred");
                    break;
                }
            }
            for (int i = 0; i < arrayA.length; i++) {
                if (array3X[1] == arrayA[i]) {
                    if (i == 0) {
                        System.out.print("");
                    } else if (i == 2) {
                        System.out.print(" and twenty");
                    } else if (i == 3) {
                        System.out.print(" and thirty");
                    } else if (i == 5) {
                        System.out.print(" and fifty");
                    } else {
                        System.out.print(" and " + arrayB[i] + "ty");
                        break;
                    }
                }
            }
            for (int i = 0; i < arrayA.length; i++) {
                if (i == 0) {
                    System.out.println(" ");
                } else if (array3X[2] == arrayA[i]) {
                    System.out.println(" and " + arrayB[i]);
                    break;
                } else {
                    System.out.println(" - " + arrayB[i]);
                    break;
                }
            }
        }
    }
}


