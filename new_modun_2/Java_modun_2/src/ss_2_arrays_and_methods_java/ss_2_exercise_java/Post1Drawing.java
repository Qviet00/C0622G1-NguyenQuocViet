package ss_2_arrays_and_methods_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post1Drawing {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int height;
        int width;
        int i;
        int j;
        System.out.println("Nhập độ dài:");
        height = src.nextInt();
        System.out.println("Nhập độ rộng:");
        width = src.nextInt();
        for ( i = 0; i < height; i++) {
            for ( j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        for ( i = 1; i <= height; i++) {
            for ( j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for ( i = height; i > 0; i--) {
            for ( j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}

