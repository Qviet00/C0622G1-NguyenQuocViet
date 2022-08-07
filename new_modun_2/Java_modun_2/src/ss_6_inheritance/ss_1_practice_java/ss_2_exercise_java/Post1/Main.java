package ss_6_inheritance.ss_1_practice_java.ss_2_exercise_java.Post1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập bán kính(metter): ");
        double r = Integer.parseInt(src.next());
        System.out.print("Nhập chiều cao(metter): ");
        double h = Integer.parseInt(src.next());
        Circle circle= new Circle(r,"Blue");
        Cylinder cylinder=new Cylinder(circle.getRadius(), circle.getColor(), h);
        System.out.println(circle);
        System.out.println(cylinder);
    }
}