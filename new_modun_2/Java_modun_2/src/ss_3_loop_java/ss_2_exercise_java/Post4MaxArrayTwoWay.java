package ss_3_loop_java.ss_2_exercise_java;

import java.util.Arrays;
import java.util.Scanner;

public class Post4MaxArrayTwoWay {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int i;
        int j;
        int n;
        System.out.print("Nhập độ dài mảng hai chiều: ");

        do {
            n = src.nextInt();
            if (n < 0) {
                System.out.println("Số nhập không đúng,Vui lòng nhập lại");
            }
        } while (n < 0);
        int m;
        System.out.print("Nhập số độ dài mảng con: ");
        do {
            m = src.nextInt();
            if (m < 0) {
                System.out.println("Số nhập không đúng,Vui lòng nhập lại");
            }
        } while (m < 0);
        int[][] arrayTwoWay = new int[n][m];
        for ( i = 0; i < n; i++) {
            for ( j = 0; j < m; j++) {
                System.out.print("Nhập phần tử thứ " + (j + 1) + " của mảng " + (i + 1) + ": ");
                arrayTwoWay[i][j] = Integer.parseInt(src.nextLine());
            }
        }
        for (int[] unit : arrayTwoWay) System.out.println(Arrays.toString(unit) + "\t");
        int maxElement = arrayTwoWay[0][0];
        for (int[] ints : arrayTwoWay) {
            for ( j = 1; j < ints.length; j++) {
                if (ints[j] > maxElement) {
                    maxElement = ints[j];
                }
            }
        }
        System.out.println("Gía trị lớn nhất của mảng hai chiều:" + maxElement);
    }
}
