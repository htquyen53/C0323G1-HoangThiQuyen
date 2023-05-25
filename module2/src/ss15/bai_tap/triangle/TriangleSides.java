package ss15.bai_tap.triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleSides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các kích thước: ");
        double a;
        double b;
        double c;
        do {
            System.out.print("Nhập kích thước đầu tiên: a = ");
            try {
                a = scanner.nextDouble();
                if (a <= 0) {
                    throw new IllegalTriangleException("Vui lòng nhập lại, a > 0");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng");
            } catch (Exception e) {
                System.out.println("Error");
            }

        } while (true);
        do {
            System.out.print("\nNhập kích thước thứ hai: b = ");
            try {
                b = scanner.nextDouble();
                if (b <= 0) {
                    throw new IllegalTriangleException("Vui lòng nhập lại, b > 0");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng");
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (true);
        do {
            System.out.print("\nNhập kích thước thứ ba: c = ");
            try {
                c = scanner.nextDouble();
                if (c <= 0) {
                    throw new IllegalTriangleException("Vui lòng nhập lại, c > 0");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng");
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (true);
        try {
            checkTriangle(a, b, c);
        } catch (IllegalTriangleException illegalTriangleException) {
            System.out.println(illegalTriangleException.getMessage());
        } finally {
            System.out.println("Ctrl + F5 để kiểm tra lại!");
        }
    }


    public static void checkTriangle(double firstSide, double secondSide, double thirdSide) throws
            IllegalTriangleException {
        if (firstSide + secondSide <= thirdSide || firstSide + thirdSide <= secondSide
                || secondSide + thirdSide <= thirdSide) {
            throw new IllegalTriangleException("Ba kích thước đã nhập không phải là cạnh của tam giác!");
        }
        System.out.println("Nhập thành công kích thước của 1 tam giác!");
    }
}