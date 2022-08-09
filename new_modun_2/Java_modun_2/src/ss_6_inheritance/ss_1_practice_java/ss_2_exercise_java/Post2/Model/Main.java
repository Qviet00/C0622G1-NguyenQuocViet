package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post2.Model;

import ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post2.Controller.Point2D;
import ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post2.Controller.Point3D;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(4, 5);
        Point3D point3D = new Point3D(point2D.getX(), point2D.getY(), 6);

        System.out.println(point2D);
        System.out.println(point3D);
    }
}
