package ss4.bai_tap;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 10, "yelow");
        Fan fan2 = new Fan(2, false, 5, "blue");
        System.out.println(fan1);
        fan1.displayOn();
        System.out.println(fan2);
        fan2.displayOff();
    }
}
