package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Mode;

public class Square extends Circle implements Colorable{
    private double height;

    public Square() {
    }

    public Square(double height) {
        this.height = height;
    }

    public Square(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Square(boolean filler, String color, double radius, double height) {
        super(radius, color, filler);
        this.height = height;
    }

    public double getPerimeter() {
        return getArea() * this.height;
    }

    public boolean howToColor() {
        System.out.print("Color all four sides");
        return false;
    }

    @Override
    public String toString() {
        return "Square{" + "height=" + height + ", Primeter: " + getPerimeter() + "} " + super.toString();
    }

}
