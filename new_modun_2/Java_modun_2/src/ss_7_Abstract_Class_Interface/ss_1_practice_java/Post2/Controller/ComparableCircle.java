package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post2.Controller;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
        super();
    }
    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, boolean filled, String color) {
        super(radius, filled, color);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}

