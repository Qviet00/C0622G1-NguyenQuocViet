package ss_1_introduction_to_java.ss_1_practice_java;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {

        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập a:");
        double a = scanner.nextDouble();
        System.out.print("Nhập b:");
        double b = scanner.nextDouble();
        System.out.print("Nhập c:");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.println("Phương trình có 1 Nghiệm:" + answer);
        } else {
            if (b == c) {
                System.out.print("Phương trình vô số Nghiệm.");
            } else {
                System.out.print("Phương trình vô Nghiệm.");
            }
        }
    }
}
