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
        return this.radius*this.radius*Math.PI;
    }
    public double getPerimeter(){
        return Math.PI*this.radius;
    }

    @Override
    public String toString() {
        return String.format("Rdius: %f, Area: %.2f, Metter: %.2f", this.radius,getArea(),getPerimeter());
    }
}
