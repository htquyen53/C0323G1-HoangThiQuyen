package ThiThuatToan;

import java.util.Scanner;

public class Test2 {
    static boolean solution(int[] a) {
        int sum1 = 0;
        int sum2 = 0;
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum1 += a[i];
            for (int j = a.length - 1; j > a.length - i; j--) {
                sum2 += a[j];
                for (int k : arr) {
                    arr[k] = a[j];
                }
                if (sum1 == sum2 && isEmpty(arr)  && !checkElement(arr[a.length-i],arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isEmpty(int[] array) {
        for (int j : array) {
            if (j != 0) {
                return true;
            }
        }
        return false;
    }
    static boolean checkElement(int element, int[] array) {
        for (int y:array) {
            if(y == element) return true;
        } return false;
    }
    public static void main(String[] args) {
        int[] b = {1, 2, 3, 3};
        int[] c = {1, 2, 3};
        int[] d = {1, 2, -3,0,0,0,0};
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
    }
}

