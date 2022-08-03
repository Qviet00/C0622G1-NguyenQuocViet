package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post3CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD:");
        double vnd = scanner.nextDouble();
        System.out.println("Số tiền quy đổi:" + vnd * 23000+ "VND");
    }
}
