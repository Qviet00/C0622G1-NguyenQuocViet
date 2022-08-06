package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volumeTric() {
        return this.area() * this.height;

    }

    public String string1() {
        return String.format("Volumetric: %.3f", volumeTric());
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "Radius" + getRadius() +
                ", Color" + getColor() +
                ", Height= " + height + " (meter)" +
                ", " + string1() + " (meter3)" +
                '}';
    }
}
