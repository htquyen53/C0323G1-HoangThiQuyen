package ss5.bai_tap.access_modifier;

public class Cirle {
    private double radius = 1;
    private String color = "red";
    static final double PI = 3.14;

    public Cirle() {
    }

    public Cirle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return this.radius * this.radius * PI;
    }

    @Override
    public String toString() {
        return "Cirle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
