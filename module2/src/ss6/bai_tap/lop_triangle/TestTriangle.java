package ss6.bai_tap.lop_triangle;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();
        System.out.println("Enter the side 1: ");
        double side1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the side 2: ");
        double side2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the side 3: ");
        double side3 = Double.parseDouble(scanner.nextLine());
        Triangle triangle = new Triangle(color, side1, side2, side3);
        System.out.println(triangle);
        System.out.println("The Area of Triangle: " + triangle.getArea());
        System.out.println("The Perimeter of Triangle: " + triangle.getPerimeter());
    }
}
