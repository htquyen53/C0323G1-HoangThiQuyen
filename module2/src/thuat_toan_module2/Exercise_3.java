package thuat_toan_module2;

public class Exercise_3 {
    // Kiểm tra mảng có “đẹp” hay không.
    // Một mảng được gọi là "đẹp" nếu mảng đó chứa một phần tử mà phần tử đó chia mảng
    // làm 2 phần (không rỗng và không chứa phần tử đó) có tổng bằng nhau.
    public static boolean checkBeautyArray(int[] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum1 += arr[i];
            int sum2 = 0;
            for (int j = arr.length - 1; j > i - 1; j--) {
                sum2 += arr[j];
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3, 3};
        System.out.println(checkBeautyArray(a));
        System.out.println(checkBeautyArray(b));
    }
}
