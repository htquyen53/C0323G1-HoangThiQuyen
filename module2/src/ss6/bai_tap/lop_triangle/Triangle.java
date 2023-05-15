package ss6.bai_tap.lop_triangle;

import ss6.thuc_hanh.lop_cha_lop_con.Cirle;
import ss6.thuc_hanh.lop_cha_lop_con.Geometric;

public class Triangle extends Geometric {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(String color, double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setColor(color);
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        double p = getPerimeter();
        return Math.round(Math.pow((p*(p-side1)*(p-side2)*(p-side3)),0.5));
    }
    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color: " + getColor() +
                ", side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                '}';
    }
}
