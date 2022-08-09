package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post2.Model;

import java.util.Arrays;

import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post2.Controller.ComparableCircle;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(2);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3, true, "red");
        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
