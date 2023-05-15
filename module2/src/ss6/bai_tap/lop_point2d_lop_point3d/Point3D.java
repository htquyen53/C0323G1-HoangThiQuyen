package ss6.bai_tap.lop_point2d_lop_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public float[] getXYZ() {
        float[] arrXYZ = {getX(), getY(), getZ()};
        return arrXYZ;
    }

    @Override
    public String toString() {
        return Arrays.toString(getXYZ());
    }
}
