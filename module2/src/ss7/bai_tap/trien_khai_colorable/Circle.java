package ss7.bai_tap.trien_khai_colorable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }



    @Override
    public void resize(double percent) {
        setRadius(getRadius() + getRadius() * percent);
    }

    @Override
    public String toString() {
        return super.toString() + ", radius = " + getRadius() + ", area  = " + getArea();
    }
}
