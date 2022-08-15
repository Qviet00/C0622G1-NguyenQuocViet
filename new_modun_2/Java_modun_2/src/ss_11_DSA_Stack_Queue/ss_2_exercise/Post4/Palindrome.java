package ss_11_DSA_Stack_Queue.ss_2_exercise.Post4;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("Enter string to be checked:  ");
        Scanner src = new Scanner(System.in);
        String string = src.nextLine();
        Queue<Character> queue = new LinkedList<>();
        for (int i = string.length() - 1; i >= 0; i--) {
            queue.add(string.charAt(i));
        }
        StringBuilder symmetry = new StringBuilder();
        while (!queue.isEmpty()) {
            symmetry.append(queue.remove());
        }
        if (string.equals(symmetry.toString()))
            System.out.println("Yes is string Symmetry.");
        else
            System.out.println("Not is string Symmetry");
    }
}
