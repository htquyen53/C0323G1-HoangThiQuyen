package ss3.audit;

import java.util.Scanner;

public class demo6 {
    // Cho 1 số nhập từ bàn phím, in ra số ngược lại (chỉ xử lý số, không sử dụng chuỗi hoặc mảng ).
    //VD: nhập vào 1523 kết quả là 3251.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số =  ");
        int number = scanner.nextInt();
        int reverseNumber = 0;
        while (number!=0) {
            int a = number%10;
            reverseNumber = reverseNumber*10 + a;
            number = number/10;
        }
        System.out.println(reverseNumber);

    }
}
