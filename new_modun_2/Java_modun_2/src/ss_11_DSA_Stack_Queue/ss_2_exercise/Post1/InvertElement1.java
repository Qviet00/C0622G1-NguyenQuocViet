package ss_11_DSA_Stack_Queue.ss_2_exercise.Post1;

import java.util.Scanner;

public class InvertElement1 {
    private static void invert(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void reverse(char[] array) {
        int n = array.length;
        int i;
        for (i = 0; i < n / 2; i++) {
            invert(array, i, n - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhap ki tu: ");
        String array = String.format(src.nextLine());
        String s2 = array.replaceAll("\\s\\s+", " ").trim();
        char[] s = s2.toCharArray();
        InvertElement1.reverse(s);
        System.out.printf(String.valueOf(s));
    }
}
