package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post3.Model;

import ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post3.Controller.MoveablePoint;
import ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post3.Controller.Point;

public class Main {
    public static void main(String[] args) {
        Point point= new Point(4,5);
        MoveablePoint moveablePoint= new MoveablePoint(point.getX(),point.getY(),6,7);
        System.out.println(point);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
