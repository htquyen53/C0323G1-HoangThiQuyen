package ss6.bai_tap.lop_point2d_lop_point3d;

import java.util.Scanner;

public class TestPoint3D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập x = ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập y = ");
        float y = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập z = ");
        float z = Float.parseFloat(scanner.nextLine());
        Point3D point3D = new Point3D(x, y, z);
        System.out.println(point3D);
    }
}
