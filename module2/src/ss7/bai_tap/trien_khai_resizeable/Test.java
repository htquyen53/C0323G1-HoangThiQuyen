package ss7.bai_tap.trien_khai_resizeable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(6, "blue", false);
        shapes[1] = new Square(5, "black", true);

        for (Shape shape : shapes) {
            System.out.println("The Area of " + shape.getName() + " is: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
