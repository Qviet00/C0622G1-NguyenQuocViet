package ss_3_loop_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post8CharacterCountArray {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập chuỗi muốn kiểm tra: ");
        String string = String.valueOf(src.nextLine());
        System.out.print("Nhập kí tự cần tìm: ");
        char charracter = src.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (charracter == string.charAt(i)) {
                count++;
            }
        }
        System.out.println("Số kí tự có trong chuỗi là: "+ count);
    }
}
