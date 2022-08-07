package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post1;

public  class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = (height>=0?height:0);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = (height>=0?height:0);
    }

    public double volumeTric() {
        return this.area() * this.height;

    }

    public String string1() {
        return String.format("Volumetric= %.1f", volumeTric());
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "Radius=" + getRadius() +" (meter)"+
                ", Color:" + getColor() +
                ", Height= " + height + " (meter)" +
                ", " + string1() + " (meter3)" +
                '}';
    }
}
