package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class Post2ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập số đi bạn:");
        int number = src.nextInt();
        String hundreds = null;
        String dozens = null;
        String unit = null;
        if (number > 10 && number < 20) {
            switch (number) {
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                case 13:
                    System.out.println("Thirteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eighteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
        } else {
            if (number < 1001 && number > 20) {
                int hundreds1 = number / 100;
                int dozens1 = number % 100;
                int interger3 = dozens1 / 10;
                int unit1 = dozens1 % 10;
                switch (hundreds1) {
                    case 0:
                        hundreds = "";
                        break;
                    case 1:
                        hundreds = "Onehundred";
                        break;
                    case 2:
                        hundreds = "Twohundred";
                        break;
                    case 3:
                        hundreds = "Therehundred";
                        break;
                    case 4:
                        hundreds = "Fourthundred";
                        break;
                    case 5:
                        hundreds = "Fivehundred";
                        break;
                    case 6:
                        hundreds = "Sixhundred";
                        break;
                    case 7:
                        hundreds = "Seventhundred";
                        break;
                    case 8:
                        hundreds = "Eighthundred ";
                        break;
                    case 9:
                        hundreds = "Ninehundred";
                        break;
                }
                switch (interger3) {
                    case 0:
                        dozens = "";
                        break;
                    case 1:
                        dozens = "and Ten";
                        break;
                    case 2:
                        dozens = "and Twenty";
                        break;
                    case 3:
                        dozens = "and Thirty";
                        break;
                    case 4:
                        dozens = "and Forty";
                        break;
                    case 5:
                        dozens = "and Fifty";
                        break;
                    case 6:
                        dozens = "and Sixty";
                        break;
                    case 7:
                        dozens = "and Seventy";
                        break;
                    case 8:
                        dozens = "and Eighty";
                        break;
                    case 9:
                        dozens = "and Ninety";
                        break;
                }
                switch (unit1) {
                    case 1:
                        unit = "One";
                        break;
                    case 2:
                        unit = "Two";
                        break;
                    case 3:
                        unit = "Three";
                        break;
                    case 4:
                        unit = "Four";
                        break;
                    case 5:
                        unit = "Five";
                        break;
                    case 6:
                        unit = "Six";
                        break;
                    case 7:
                        unit = "Seven";
                        break;
                    case 8:
                        unit = "Eight";
                        break;
                    case 9:
                        unit = "Nine";
                        break;
                }
                    System.out.println(hundreds + " " + dozens + " " + unit);
            } else {
                System.out.println(" Out Of Ability");
            }
        }
    }
}

