package ss6.bai_tap.lop_circle_lop_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5);
        System.out.println(cylinder);
        cylinder = new Cylinder(3,6,"red");
        System.out.println(cylinder);
    }
}
