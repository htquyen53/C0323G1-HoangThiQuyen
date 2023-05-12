package ss4.bai_tap;

public class Fan {
    int SLOW;
    int MEDIUM;
    int FAST;
    int speed;
    boolean on;
    double radius;
    String color;

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    void setSpeed(int speed) {

    }

    void displayOn() {
        System.out.println("Fan is on");
    }

    void displayOff() {
        System.out.println("Fan is off");
    }

    @Override
    public String toString() {
        return "Fan{" +
                ", speed=" + speed +
                ", on=" + on +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
