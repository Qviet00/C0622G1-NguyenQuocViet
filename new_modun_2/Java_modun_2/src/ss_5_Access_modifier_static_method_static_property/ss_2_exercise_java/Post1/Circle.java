package ss_5_Access_modifier_static_method_static_property.ss_2_exercise_java.Post1;

public class Circle {
    private final double radiurs;
    private final String c0lor;

    public Circle() {
        this.radiurs = 1.0;
        this.c0lor = "red";
    }

    public Circle(double radiurs, String color) {
        this.radiurs = radiurs;
        this.c0lor = color;
    }
    public double getRadiurs(){
        return this.radiurs;
    }
    public String getArea(){
        return this.c0lor;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radiurs=" + radiurs +
                ", c0lor='" + c0lor + '\'' +
                '}';
    }
}
