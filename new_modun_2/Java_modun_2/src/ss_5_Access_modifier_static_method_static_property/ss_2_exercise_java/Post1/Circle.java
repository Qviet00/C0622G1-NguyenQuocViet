package ss_5_Access_modifier_static_method_static_property.ss_2_exercise_java.Post1;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadiurs() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public String getC0lor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        double i = (this.radius * this.radius * Math.PI);
        return i;
    }
    public String toSrings(){
        return String.format("%.4f",getArea());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", c0lor='" + color + '\'' + ", "+"Area="
                +'\''+ toSrings()+" (Meter)"+'\''+
                '}';
    }


}

