package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post2;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{this.getX(), this.getY(), this.z};
    }

    @Override
    public String toString() {
        return "Point3D{" + "x= " + getX() +
                ", y= " + getY() +
                ", z= " + z +
                '}';
    }
}
