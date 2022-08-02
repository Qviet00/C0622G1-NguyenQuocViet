package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post1_DeleteArray {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[] arrayOne = {1, 2, 3, 4, 5, 6, 7, 8};
        int deleteIndex = -1;
        int valueX;
        System.out.println("Nhập giá trị X:");
        valueX = src.nextInt();
        for (int i = 0; i < arrayOne.length - 1; i++) {
            if (valueX == arrayOne[i]) {
                deleteIndex = i;
                break;
            }
        }
        if (deleteIndex > -1) {
            for (int i = deleteIndex; i < arrayOne.length - 1; i++) {
                arrayOne[i] = arrayOne[i + 1];
                arrayOne[arrayOne.length - 1] = 0;
            }
        }
        for (int number : arrayOne) {
            System.out.print(number + "\t");
        }
    }

}
