package ss_4_class_and_oject_in_java.ss_2_exercise_java;

import java.util.Scanner;

public interface Post1QuadraticEquation2 {

    class QuadraticEquation2 {
        double a, b, c, dellta;

        public QuadraticEquation2(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant() {
            return dellta = this.b * this.b - (4 * this.a * this.c);
        }

        public double valuaOne() {
            return this.c / this.b;
        }

        public double valueTwo() {
            return (-this.b * this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
        }

        public double valueThere() {
            return (-this.b * this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
        }
    }

    static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập a = ");
        double a = Integer.parseInt(src.nextLine());
        System.out.print("Nhập b = ");
        double b = Integer.parseInt(src.nextLine());
        System.out.print("Nhập c = ");
        double c = Integer.parseInt(src.nextLine());
        QuadraticEquation2 quadraic = new QuadraticEquation2(a, b, c);
        double valueOne = quadraic.valueTwo();
        double valueTwo = quadraic.valueThere();
        if (a == 0 && b == 0) {
            System.out.print("Phương trình vô Nghiệm");
        } else {
            if (a == 0) {
                System.out.print("Phương trình có 1 nghiệm = " + quadraic.valuaOne());
            } else {
                System.out.print("Phương trình có 2 nghiệm: " + "Ngiệm 1 = " + valueOne + ", Nghiệm 2 = " + valueTwo);
            }
        }

    }
}
