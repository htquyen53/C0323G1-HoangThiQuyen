package ss7.bai_tap.trien_khai_resizeable;

public class SquareX extends Shape implements Colorable {
    private double side;
    public SquareX(){
    }
    public SquareX(double side) {
        this.side = side;
    }
    public SquareX(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea(){
        return side*side;
    }
    public String getName() {return "Square";}

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "SquareX{" + super.toString() +
                "side =" + side + " , Area = " + getArea() +
                '}';
    }
}
