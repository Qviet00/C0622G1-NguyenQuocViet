package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;
import java.util.Arrays;

public class Post3_AddArrayOneAndArrayTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của 2 mảng:");
        int n = scanner.nextInt();
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        int[] arrayThree = new int[arrayOne.length + arrayTwo.length];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + "của mảng 1: ");
            arrayOne[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; j++) {
            System.out.print("Nhập phần tử thứ " + (j + 1) + "của mảng 2: ");
            arrayTwo[j] = scanner.nextInt();
        }
        System.arraycopy(arrayOne, 0, arrayThree, 0, arrayOne.length);
        System.arraycopy(arrayTwo, 0, arrayThree, arrayOne.length, arrayTwo.length);

        System.out.println(Arrays.toString(arrayThree));
    }

}
