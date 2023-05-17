package ss7.bai_tap.trien_khai_resizeable;

public class Circle extends Shape {
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
        return "Circle{" + super.toString() +
                "radius=" + radius + " , Area = " + getArea() +
                '}';
    }
}
