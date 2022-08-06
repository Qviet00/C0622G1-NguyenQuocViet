package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post1;

public class Main {
    public static void main(String[] args) {
        Circle circle= new Circle(5,"Blue");
        Cylinder cylinder=new Cylinder(circle.getRadius(), circle.getColor(), 5);
        System.out.println(circle);
        System.out.println(cylinder);
    }
}