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


    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadiurs() {
        return radius;
    }

    public void setRadiurs(double radiurs) {
        this.radius = radiurs;
    }

    public String getC0lor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", c0lor='" + color + '\'' +
                ']';
    }
}

