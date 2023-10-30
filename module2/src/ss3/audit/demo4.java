package ss3.audit;

public class demo4 {
    public static void main(String[] args) {
        // Đảo ngược một số không dùng các phương thức của chuỗi hay mảng mà chỉ là thuần xử lí số.
        int x = 123456789;
        int reverseNumber = 0;
        while (x!=0) {
            int a = x%10;
            reverseNumber = reverseNumber*10 + a;
            x = x/10;
        }
        System.out.println(reverseNumber);
    }
}
