package ss6.bai_tap.lop_point_lop_moveable_point;

import java.util.Scanner;

public class TestMovablePoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x = ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter y = ");
        float y = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter xSpeed = ");
        float xSpeed = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter ySpeed = ");
        float ySpeed = Float.parseFloat(scanner.nextLine());
        MovablePoint movablePointPre = new MovablePoint();
        System.out.println(movablePointPre);
        MovablePoint movablePoint = new MovablePoint(x, y, xSpeed, ySpeed);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
