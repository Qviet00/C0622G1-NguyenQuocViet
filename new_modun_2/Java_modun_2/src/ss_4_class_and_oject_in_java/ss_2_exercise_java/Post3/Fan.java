package ss_4_class_and_oject_in_java.ss_2_exercise_java.Post3;

public class Fan {
    final int slow = 1;
    final int medium = 2;

    final int hard = 3;
    private int speed;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.on){
            return String.format("Speed: %d Color: %s Radius: %f fan is on",this.speed, this.color, this.radius );
        }
        else {
            return String.format("Color: %s Radius: %f fan is off", this.color, this.radius );

        }
    }
}
