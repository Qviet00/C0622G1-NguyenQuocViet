package ss_11_DSA_Stack_Queue.ss_2_exercise.Post1;

import java.util.Scanner;
import java.util.Stack;

public class InvertElement {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter string: ");
        String stringOne = String.valueOf(src.nextLine());
        String stringTwo = stringOne.replaceAll("\\s\\s+", " ").trim();
        char[] stringThree = stringTwo.toCharArray();
        Stack<Object> stack = new Stack<>();
        for (int i = stringThree.length - 1; i >= 0; i--) {
            stack.push(stringThree[i]);
        }
        StringBuilder total = new StringBuilder();
        for (Object stacks : stack) {
            total.append(stacks);
        }
        System.out.println(total);
    }
}
