package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Mode;

public class Rectangle extends Shape implements Colorable {
    private double width;
    private double heidth;

    public Rectangle(double percent) {
    }

    public Rectangle(double weight, double heidth) {
        this.width = weight;
        this.heidth = heidth;
    }

    public Rectangle(boolean filler, String color, double weight, double heidth) {
        super(color, filler);
        this.width = weight;
        this.heidth = heidth;
    }

    public double getArea() {
        return this.heidth * this.width;
    }

    public double getPrimeter() {
        return 2 * (this.width + this.heidth);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", heidth=" + heidth +
                ", Area: " + getArea() +
                ", Primeter: " + getPrimeter() +
                "} " + super.toString();
    }

    @Override
    public boolean howToColor() {
        System.out.println("Filled Rectangle");

        return false;
    }
}
