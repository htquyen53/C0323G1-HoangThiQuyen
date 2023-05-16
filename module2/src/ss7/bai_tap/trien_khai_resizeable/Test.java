package ss7.bai_tap.trien_khai_resizeable;

import ss7.bai_tap.trien_khai_colorable.Circle;
import ss7.bai_tap.trien_khai_colorable.Square;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new CircleX(6, "blue", false);
        shapes[1] = new SquareX(5, "black", true);

        for (Shape shapeX : shapes) {
            System.out.println("The Area of " + shapeX.getName() + " is: " + shapeX.getArea());
            if (shapeX instanceof Colorable) {
                ((Colorable) shapeX).howToColor();
            }
        }
    }
}
