package ss7.bai_tap.trien_khai_resizeable;

public class CircleX extends Shape {
    private double radius;
    public CircleX() {
    }

    public CircleX(double radius) {
        this.radius = radius;
    }

    public CircleX(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public String getName() {return "Circle";}

    @Override
    public String toString() {
        return "CircleX{" + super.toString() +
                "radius=" + radius + " , Area = " + getArea() +
                '}';
    }
}
