package ss6.bai_tap.lop_point2d_lop_point3d;

import java.util.Scanner;

public class TestPoint2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x= ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter y= ");
        float y = Float.parseFloat(scanner.nextLine());
        Point2D point2D = new Point2D();
        Point2D point2D1 = new Point2D(x,y);
        System.out.println(point2D);
        System.out.println(point2D1);
    }
}
