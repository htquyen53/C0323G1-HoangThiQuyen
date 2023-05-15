package ss6.bai_tap.lop_point_lop_moveable_point;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;
    public Point(){
    }
    public Point( float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return this.x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return this.y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        float[] arrXY = {this.x, this.y};
        return arrXY;
    }
    public String toString() {
        return Arrays.toString(getXY());
    }
}
