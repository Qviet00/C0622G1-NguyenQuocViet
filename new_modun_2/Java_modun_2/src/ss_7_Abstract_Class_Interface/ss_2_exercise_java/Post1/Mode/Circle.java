package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Mode;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(boolean filler, String color, double radius) {
        super(filler, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return this.radius*this.radius*3.14;
    }
    public double getPerimeter(){
        return 2*3.14*this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", Area: "+ getArea()+
                ", Primeter: "+ getPerimeter()+
                "} " + super.toString();
    }
}
