package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post2_ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Nhập số đi bạn:");
        int number = src.nextInt();
            switch (number) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("There");
                    break;
                case 4:
                    System.out.println("Fout");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Sevent");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nice");
                    break;
                case 10:
                    System.out.println("Ten");
                    break;
                default:
                    System.out.println("Out Of Ability");
            }
        }
    }
