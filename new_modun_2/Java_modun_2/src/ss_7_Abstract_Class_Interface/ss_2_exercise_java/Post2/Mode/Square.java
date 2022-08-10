package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post2.Mode;

public class Square extends Circle implements Colorable{
    private final double height;


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
        return String.format(
                "Radius: %.2f, Height: %.2f, Area: %.2f, Perimeter: %.2f",getRadius(),this.height,getArea(),getPerimeter());
    }

}
