package ss_11_DSA_Stack_Queue.ss_2_exercise.Post3;

import java.util.Scanner;
import java.util.*;

public class Decimal {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter decimal: ");
        int num = src.nextInt();
        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        System.out.print("Binary value: ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
