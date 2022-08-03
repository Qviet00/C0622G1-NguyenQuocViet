package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post6SumArrayTwoWay {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[][] arrayTwoWay = new int[][]{{1, 2, 3, 4, 6}, {5, 6, 7, 8, 9}};
        int sum = 0;
        int n;
        System.out.print("Nhập vị trí muốn tính tổng: ");
        do {
            n = Integer.parseInt(src.nextLine());
            if (n < 1 || n > 2) {
                System.out.println("Vui lòng nhập lại");
            }
        } while (n < 1 || n > 3);
        for (int i = 0; i < arrayTwoWay.length; i++) {
            for (int j = 0; j < arrayTwoWay[i].length; j++) {
                if (i == n - 1) {
                    sum += arrayTwoWay[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
