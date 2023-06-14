package thuat_toan_module2;

public class Exercise_10 {
    public static int exchangeMoney(int[] arr, int n) {
        int totalMoney = 0;
        int max = n;
        for (int i = 0; i < arr.length - 1; i++) {
            if (n > arr[i]) {
                for (int j = arr.length - 1; j > i ; j--) {
                    totalMoney = n - arr[i] + arr[j];
                    if (max < totalMoney) {
                        max = totalMoney;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 7};
        int n1 = 4;
        int[] arr2 = {3, 2, 1};
        int n2 = 10;
        int[] arr3 = {3, 5, 2, 7, 1};
        int n3 = 7;

        System.out.println(exchangeMoney(arr1, n1));
        System.out.println(exchangeMoney(arr2, n2));
        System.out.println(exchangeMoney(arr3, n3));
    }
}
