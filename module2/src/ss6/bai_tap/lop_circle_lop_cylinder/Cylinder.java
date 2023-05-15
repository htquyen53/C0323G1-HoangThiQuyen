package ss6.bai_tap.lop_circle_lop_cylinder;

public class Cylinder extends Cirle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.height * getRadius();
    }

    @Override
    public String toString() {
        return "A Cylinder with height = " + height + ", radius = "
                + getRadius() + " and color: " + getColor();
    }
}
