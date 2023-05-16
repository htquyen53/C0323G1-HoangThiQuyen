package ss7.bai_tap.trien_khai_colorable;

import java.util.Scanner;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(4, 5, "yelow", false);
        shapes[2] = new Square(6, "blue", true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tăng kích thước lên bao nhiêu %?");
        double percent = Double.parseDouble(scanner.nextLine());
        if (percent > 1 && percent <= 100) {
            for (Shape shape : shapes) {
                if (shape instanceof Circle) {
                    Resizeable resizeabler = (Circle) shape;
                    System.out.println("Diện tích hình tròn trước khi thay đổi là: " + ((Circle) shape).getArea());
                    resizeabler.resize(percent);
                    System.out.println("Diện tích hình tròn sau khi thay đổi là: " + ((Circle) shape).getArea());
                }
                if (shape instanceof Rectangle) {
                    Resizeable resizeabler = (Rectangle) shape;
                    System.out.println("Diện tích hình chữ nhật trước khi thay đổi là: " + ((Rectangle) shape).getArea());
                    resizeabler.resize(percent);
                    System.out.println("Diện tích hình chữ nhật sau khi thay đổi là: " + ((Rectangle) shape).getArea());
                }
                if (shape instanceof Square) {
                    Resizeable resizeabler = (Square) shape;
                    System.out.println("Diện tích hình vuông trước khi thay đổi là: " + ((Square) shape).getArea());
                    resizeabler.resize(percent);
                    System.out.println("Diện tích hình vuông sau khi thay đổi là: " + ((Square) shape).getArea());
                }
            }
        }
    }
}
