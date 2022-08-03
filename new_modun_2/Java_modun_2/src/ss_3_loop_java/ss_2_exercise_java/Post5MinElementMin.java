package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post5MinElementMin {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập phần tử " + (i + 1) + ": ");
            array[i] = Integer.parseInt(src.nextLine());
        }
        System.out.print("Măng được khởi tạo: ");
        for (int arr : array) System.out.print(arr + "\t");
        System.out.println("\n");
        int min = array[0];
        for (int j : array) {
            if (min > j) {
                min = j;
            }
        }
        System.out.println("Gía trị nhỏ nhất: " + min);
    }
}
