package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class DisplayGreetingsPost1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: :");
        String loiChao = sc.nextLine();
        System.out.println("Hello:" + loiChao);
    }
}