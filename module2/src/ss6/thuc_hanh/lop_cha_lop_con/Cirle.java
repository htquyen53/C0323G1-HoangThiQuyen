package ss6.thuc_hanh.lop_cha_lop_con;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Cirle extends Geometric {
    private double radius;

    public Cirle() {
    }

    public Cirle(double radius) {
        this.radius = radius;
    }

    public Cirle(double radius, String color, String filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }
    public void printCircle(){
        System.out.println("The " + getColor() + " circle is created with the radius is " + radius);
    }
}
