package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post2.Controller;

public class Circle {
    private boolean filled;
    private String color;
    private double radius;

    public Circle() {
    }

    public Circle(double radius){
        this.filled =true;
        this.color= "blue";
        this.radius=1.0;
    }

    public Circle(double radius, boolean filled, String color) {
        this.filled = filled;
        this.color = color;
        this.radius=radius;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "filled=" + filled +
                ", color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}
