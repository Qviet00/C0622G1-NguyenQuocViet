package ss_11_DSA_Stack_Queue.ss_2_exercise.Post5.Post3.Controller;

import java.util.Scanner;

public class ConvertBinary {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhap so di ban(n>0): ");
        int n = Integer.parseInt(src.next());
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, (n % 2));
            n = n / 2;
        }
        System.out.print("So he nhi phan la: " + binary);
    }
}
