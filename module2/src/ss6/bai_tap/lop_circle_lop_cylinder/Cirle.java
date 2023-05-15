package ss6.bai_tap.lop_circle_lop_cylinder;

public class Cirle {
    private double radius;
    private String color;
    public Cirle(){
    }
    public Cirle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Cirle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                " , Area = " + getArea() +
                '}';
    }
}
