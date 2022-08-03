package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;
import java.util.Arrays;

public class Post2AddArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 5, 9, 7, 8, 9, 15};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử muốn chèn: ");
        int num = scanner.nextInt();
        System.out.print("Nhập vị trí muốn chèn: ");
        int index = scanner.nextInt();
        if (index < 0 || index > arr.length-1) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = num;
            System.out.println(Arrays.toString(arr));
        }
    }
}



