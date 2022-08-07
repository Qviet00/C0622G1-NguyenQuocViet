package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post1;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = (radius>=0?radius:0);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = (radius>=0?radius:0);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public String toString1() {
        return String.format("Area= %.1f", area());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius + " (meter)" +
                ", color:" + color  +
                ", " + toString1() + " (meter2)" +
                '}';
    }
}
