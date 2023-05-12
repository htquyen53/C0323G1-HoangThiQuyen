package ss1.bai_tap;

import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate = 23000;
        System.out.println("USD =  ");
        double usd = scanner.nextDouble();
        double vnd = usd * rate;
        System.out.println("VND =  " + vnd);
    }
}
