package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Mode;

public class Square extends Circle {
    private final double height;

    public Square(double height) {
        this.height = height;
    }

    public Square(boolean filler, String color, double radius, double height) {
        super(filler, color, radius);
        this.height = height;
    }

    public double getPerimeter() {
        return getArea() * this.height;
    }

    @Override
    public String toString() {
        return String.format("Radius: %.2f, Area: %.2f, Petter: %.2s, Color: %s, Filler: %s ", getRadius(), getArea(), getPerimeter(), getColor(), this.isFiller());
    }
}
