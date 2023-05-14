package ss4.bai_tap;

import java.util.Scanner;

public class QuadraticEquament {
    double a;
    double b;
    double c;

    public QuadraticEquament(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getRoot() {
        return -this.c / this.b;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
    }

    public static void main(String[] args) {
        System.out.println("Giải phương trình bậc 2 với: ");
        System.out.println("Nhập hệ số a = ");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println("Nhập hệ số b = ");
        double b = scanner.nextDouble();
        System.out.println("Nhập hệ số c = ");
        double c = scanner.nextDouble();
        QuadraticEquament quadraticEquament = new QuadraticEquament(a, b, c);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình vô số nghiệm!");
                } else {
                    System.out.println("Phương trình vô nghiệm!!");
                }
            } else System.out.println("Đây là phương trình bậc nhất với nghiệm là: " + quadraticEquament.getRoot());
        } else {
            if (quadraticEquament.getDiscriminant() > 0) {
                System.out.println("Phương trình có 2 nghiệm là: ");
                System.out.println("x1 = " + quadraticEquament.getRoot1());
                System.out.println("x2 = " + quadraticEquament.getRoot2());
            } else if (quadraticEquament.getDiscriminant() == 0)
                System.out.println("Phương trình có nghiệm duy nhất x = " + quadraticEquament.getRoot1());
            else
                System.out.println("Phương trình vô nghiệm!!!");
        }
    }
}
