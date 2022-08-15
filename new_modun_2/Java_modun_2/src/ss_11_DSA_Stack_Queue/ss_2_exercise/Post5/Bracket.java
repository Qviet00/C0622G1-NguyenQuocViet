package ss_11_DSA_Stack_Queue.ss_2_exercise.Post5;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = String.valueOf(src.nextLine());
        System.out.println(tests(string));
    }

    public static boolean tests(String s) {
        Stack<Character> test = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);
            if (o == '(') {
                test.push(o);
            } else if (o == ')') {
                if (test.isEmpty()) {
                    return false;
                }
                test.pop();
            }
        }
        return test.isEmpty();
    }
}

