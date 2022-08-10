package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Mode;

public class Rectangle extends Shape implements Colorable {
    private final double width;
    private final double heidth;

    public Rectangle(boolean filler, String color, double weight, double heidth) {
        super(color, filler);
        this.width = weight;
        this.heidth = heidth;
    }

    public double getArea() {
        return this.heidth * this.width;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.heidth);
    }

    @Override
    public String toString() {
        return String.format(
                "Width %.2f, Height: %.2f Area: %.2f, Perimeter: %2.f", this.width, this.heidth, getArea(), getPerimeter());
    }

    @Override
    public boolean howToColor() {
        System.out.println("Filled Rectangle");

        return false;
    }
}
