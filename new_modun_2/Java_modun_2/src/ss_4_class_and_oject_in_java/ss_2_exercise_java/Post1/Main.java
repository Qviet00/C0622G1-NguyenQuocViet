package ss_4_class_and_oject_in_java.ss_2_exercise_java.Post1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập a = ");
        double a = Integer.parseInt(src.nextLine());
        System.out.print("Nhập b = ");
        double b = Integer.parseInt(src.nextLine());
        System.out.print("Nhập c = ");
        double c = Integer.parseInt(src.nextLine());
        QuadraticEquation quadraic = new QuadraticEquation(a, b, c);
        double valueOne = quadraic.valueTwo();
        double valueTwo = quadraic.valueThere();
        double valueFourt = quadraic.valueFout();
        double detal = quadraic.getDiscriminant();
        if (a == 0 && b == 0) {
            System.out.print("Phương trình vô Nghiệm");
        } else {
            if (a == 0) {
                System.out.print("Phương trình có 1 nghiệm = " + quadraic.valuaOne());
            } else {
                if (detal > 0) {
                    System.out.print("Phương trình có 2 nghiệm: " + "Ngiệm 1 = " + valueOne + ", Nghiệm 2 = " + valueTwo);
                } else {
                    if (detal == 0) {
                        System.out.println("Phương trình có Nghiệm kép: " + valueFourt);
                    } else {
                        System.out.println("Phương trình vô Nghiệm");
                    }
                }
            }
        }
    }
}
