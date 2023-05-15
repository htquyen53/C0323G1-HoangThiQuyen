package ss6.thuc_hanh.lop_cha_lop_con;

public class Geometric {
    private String color = "white";
    private String filled = null;

    public Geometric() {
    }

    public Geometric(String color, String filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFilled() {
        return this.filled;
    }

    public void setFilled(String filled) {
        this.filled = filled;
    }

    public String toString() {
        return "creat with \"" + color + "\" color and " + (filled == null ? "no fill":
        "filled with \"" + filled + "\" color");
    }
}
