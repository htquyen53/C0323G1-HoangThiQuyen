package thuat_toan_module2;

public class Exercise_5 {
    public static void sortByHeight(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] != -1) {
                    if (arr[i] < arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] arr2 = {-1, 150, 165, 170, -1, -1, 160, 180};
        for (Integer number : arr1) {
            System.out.print(number + "\t");
        }
        System.out.println("\n");
        for (Integer number : arr2) {
            System.out.print(number + "\t");
        }
        sortByHeight(arr1);
        sortByHeight(arr2);
        System.out.println("\n");
        for (Integer number : arr1) {
            System.out.print(number + "\t");
        }
        System.out.println("\n");
        for (Integer number : arr2) {
            System.out.print(number + "\t");
        }
    }
}
