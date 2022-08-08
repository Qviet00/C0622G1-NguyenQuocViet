package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.Post2;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius ){
        this.radius = radius;
    }

    public Circle(String color, boolean fileed, double radius) {
        super(color, fileed);
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
        return 2*this.radius*Math.PI;
    }
    public String toStringArea(){
        return String.format("%.2d",getArea());
    }
    public String toStringPerimeter(){
        return String.format("%2.d",getPerimeter());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
