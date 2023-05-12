package ss3.bai_tap;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        str = scanner.nextLine();
        System.out.println("Nhập ký tự muốn kiểm tra: ");
        char character;
        character = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Ký tự "+ character
                + " xuất hiện trong chuỗi đã nhập "+ count +" lần");
    }
}
