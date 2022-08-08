package ss_6_inheritance.ss_1_practice_java.ss_1_practice_java.post1.Post2;

public class Shape {
    private String color;
    private boolean fileed;

    public Shape() {
        this.color = "grend";
        this.fileed = true;

    }

    public Shape(String color, boolean fileed) {
        this.color = color;
        this.fileed = fileed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFileed() {
        return fileed;
    }

    public void setFileed(boolean fileed) {
        this.fileed = fileed;
    }

    @Override
    public String toString() {
        return "Shap{" +
                "color='" + color + '\'' +
                ", fileed=" + fileed +
                '}';
    }
}
