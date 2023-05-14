package ss5.bai_tap.access_modifier;

import java.util.Scanner;

public class TestCirle {
    public static void main(String[] args) {
        System.out.println("Input the radius: ");
        Scanner scanner = new Scanner(System.in);
        double radius1 = scanner.nextDouble();
        Cirle cirle1 = new Cirle(radius1);
        System.out.println("The radius you entered is: " + cirle1.getRadius());
        System.out.println("The area of circle you created is: " + cirle1.setArea());

    }
}
