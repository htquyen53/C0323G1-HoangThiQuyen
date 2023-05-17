package ss7.bai_tap.trien_khai_colorable;

import java.util.Scanner;

public class TestResizeable {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5, "red", true);
        shapes[1] = new Rectangle(4, 5, "yelow", false);
        shapes[2] = new Square(6, "blue", true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much do you want to increase the size to??");
        double percent = Double.parseDouble(scanner.nextLine());
        if (percent > 1 && percent <= 100) {
            for (Resizeable shape : shapes) {
                System.out.println("The area of " + shape.getName() + " before changed = " + shape.getArea());
                shape.resize(percent);
                System.out.println("The area of " + shape.getName() + "  after changed = " + shape.getArea());

            }
        }
    }
}

