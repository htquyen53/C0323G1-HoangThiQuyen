package ss7.bai_tap.trien_khai_resizeable;

public class Cirlce extends Shape {
    private double radius;
    public Cirlce () {
    }

    public Cirlce(double radius) {
        this.radius = radius;
    }

    public Cirlce(String color, boolean filled, double radius) {
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

    @Override
    public String toString() {
        return "Cirlce{" + super.toString() +
                "radius=" + radius +
                '}';
    }
}
