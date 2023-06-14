package thuat_toan_module2;

import java.util.Scanner;

public class Exercise_12GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập danh sách số người trong từng nhóm (cách nhau bằng dấu phẩy): ");
        String inputString = sc.nextLine(); // Nhập các số nguyên, cách nhau bằng dấu phẩy
        String[] inputArr = inputString.split(","); // Tách chuỗi thành mảng các số nguyên
        int[] xArr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            xArr[i] = Integer.parseInt(inputArr[i]); // Chuyển đổi chuỗi thành số nguyên
        }
        int countTaxi = 0;
        int passengerCount = 0;
        for (int i = 0; i < xArr.length; i++) {
            if (passengerCount + xArr[i] > 4) { // Nếu đã đủ 4 hành khách trên xe
                countTaxi++; // Thêm số lượng xe cần thuê vào kết quả
                passengerCount = xArr[i]; // Cập nhật lại số lượng hành khách trên xe mới
            } else {
                passengerCount += xArr[i]; // Thêm số lượng hành khách của nhóm tiếp theo lên xe
            }
        }
        countTaxi++; // Thêm 1 xe nữa để chở nhóm cuối cùng
        System.out.println("Số lượng taxi cần thiết để chở tất cả học sinh đến nơi là: " + countTaxi);
    }
}
