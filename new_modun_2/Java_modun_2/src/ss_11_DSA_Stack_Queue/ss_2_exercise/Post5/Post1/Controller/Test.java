package ss_11_DSA_Stack_Queue.ss_2_exercise.Post5.Post1.Controller;

import ss_11_DSA_Stack_Queue.ss_2_exercise.Post5.Post1.Model.InvertElement;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ki tu: ");
        String array = String.format(scanner.nextLine());
        String s2=array.replaceAll("\\s\\s+", " ").trim();
        char[] s = s2.toCharArray();
        InvertElement.reverse(s);
        System.out.printf(String.valueOf(s));

    } 
}
