package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post3;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setXSpeedYSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getXSpeedYSpeed() {
        return new float[]{this.xSpeed, this.ySpeed};
    }

    @Override
    public String toString() {
        return String.format("{xy=(%.1f,%.1f), Speed=(%.1f,%.1f)}", getX(), getY(), getxSpeed(),getySpeed());
    }

    public MoveablePoint move() {
       this.setX(this.getX() + this.xSpeed);
       this.setY(this.getY() + this.ySpeed);
        return this;
    }

}
