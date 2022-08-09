package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Mode;

public class Square extends Circle {
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
        super(filler, color, radius);
        this.height = height;
    }
    public double getPerimeter(){
        return getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Square{" +
                "height=" + height + ", Primeter: "+ getPerimeter()+
                "} " + super.toString();
    }
}
