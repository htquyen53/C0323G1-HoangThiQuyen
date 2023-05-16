package ss6.bai_tap.lop_point_lop_moveable_point;

import java.util.Scanner;

public class TestPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x = ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter y = ");
        float y = Float.parseFloat(scanner.nextLine());
        Point point = new Point();
        Point point1 = new Point(x, y);
        System.out.println(point);
        System.out.println(point1);
    }
}
