package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.Post2;

public class Rectangle extends Shape {
    private double width;
    private double length;
    public Rectangle(){
        this.width=1.0;
        this.length=1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean fileed, double width, double length) {
        super(color, fileed);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
