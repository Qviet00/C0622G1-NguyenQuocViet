package ss_7_Abstract_Class_Interface.ss_2_exercise_java.Post1.Mode;

public abstract class Shape implements Resizeable {
    private boolean filler;
    private String color;

    public Shape() {
    }

    public Shape(boolean filler, String color) {
        this.filler = filler;
        this.color = color;
    }

    public boolean isFiller() {
        return filler;
    }

    public void setFiller(boolean filler) {
        this.filler = filler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "filler=" + filler +
                ", color='" + color + '\'' +
                '}';
    }
}
