package ss7.bai_tap.trien_khai_colorable;

public class Rectangle extends Shape implements Resizeable {
    private double side1;
    private double side2;

    public Rectangle() {
    }

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(double side1, double side2, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }
    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void resize(double percent) {
        setSide1(getSide1() + getSide1() * percent / 100);
        setSide2(getSide2() + getSide2() * percent / 100);
    }

    @Override
    public String toString() {
        return super.toString() + " , kích thước: " + side1 + "x" + side2;
    }
}
