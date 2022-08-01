package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class Pos2_ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập số đi bạn:");
        int number = src.nextInt();
        String integer = null;
        String surplus = null;
        String surplus1 = null;
        if (number >= 0 && number <= 20) {
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
                    System.out.println("Fourt");
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
                    System.out.println("Fourteen");
                    break;
                case 15:
                    System.out.println("Fifteen");
                    break;
                case 16:
                    System.out.println("Sixteen");
                    break;
                case 17:
                    System.out.println("Seventeen");
                    break;
                case 18:
                    System.out.println("Eighteen");
                    break;
                case 19:
                    System.out.println("Nineteen");
                    break;
                case 20:
                    System.out.println("Twenty");
                    break;
            }
        } else {
            if (number < 100) {
                switch (number / 10) {
                    case 2:
                        integer = "Twenty";
                        break;
                    case 3:
                        integer = "Thirty";
                        break;
                    case 4:
                        integer = "Fourty";
                        break;
                    case 5:
                        integer = "Fitty";
                        break;
                    case 6:
                        integer = "Sixty";
                        break;
                    case 7:
                        integer = "Sevennty";
                        break;
                    case 8:
                        integer = "Eightty";
                        break;
                    case 9:
                        integer = "Nicety";
                        break;
                }
                switch (number % 10) {
                    case 1:
                        surplus = "One";
                        break;
                    case 2:
                        surplus = "Two";
                        break;
                    case 3:
                        surplus = "There";
                        break;
                    case 4:
                        surplus = "Fourt";
                        break;
                    case 5:
                        surplus = "Five";
                        break;
                    case 6:
                        surplus = "Six";
                        break;
                    case 7:
                        surplus = "Sevent";
                        break;
                    case 8:
                        surplus = "Eight";
                        break;
                    case 9:
                        surplus = "Nice";
                        break;
                }
                System.out.println(integer + " " + surplus);
            } else {
                if (number < 1001) {
                    int interger1 = number / 100;
                    int surplus2 = number % 100;
                    int interger3 = surplus2 / 10;
                    int interger4 = surplus2 % 10;
                    switch (interger1) {
                        case 1:
                            integer = "One hundred";
                            break;
                        case 2:
                            integer = "Two hundred";
                            break;
                        case 3:
                            integer = "There hundred";
                            break;
                        case 4:
                            integer = "Fourt hundred";
                            break;
                        case 5:
                            integer = "Five hundred";
                            break;
                        case 6:
                            integer = "Six hundred";
                            break;
                        case 7:
                            integer = "Sevent hundred";
                            break;
                        case 8:
                            integer = "Eight hundred ";
                            break;
                        case 9:
                            integer = "Nice hundred";
                            break;
                    }
                    switch (interger3) {
                        case 0:
                            surplus = "";
                            break;
                        case 1:
                            surplus = "and Ten";
                            break;
                        case 2:
                            surplus = "and Twenty";
                            break;
                        case 3:
                            surplus = "and Thirty";
                            break;
                        case 4:
                            surplus = "and Fourty";
                            break;
                        case 5:
                            surplus = "and Fitty";
                            break;
                        case 6:
                            surplus = "and Sixty";
                            break;
                        case 7:
                            surplus = "and Sevennty";
                            break;
                        case 8:
                            surplus = "and Eightty";
                            break;
                        case 9:
                            surplus = "and Nicety";
                            break;
                    }
                    switch (interger4) {
                        case 0:
                            surplus1 = "";
                            break;
                        case 1:
                            surplus1 = "One";
                            break;
                        case 2:
                            surplus1 = "Two";
                            break;
                        case 3:
                            surplus1 = "Three";
                            break;
                        case 4:
                            surplus1 = "Fourt";
                            break;
                        case 5:
                            surplus1 = "Five";
                            break;
                        case 6:
                            surplus1 = "Six";
                            break;
                        case 7:
                            surplus1 = "Sevent";
                            break;
                        case 8:
                            surplus1 = "Eight";
                            break;
                        case 9:
                            surplus1 = "Nice";
                            break;
                    }
                    System.out.println(integer + " " + surplus + " " + surplus1);
                }else {
                    System.out.println(" Out Of Ability");
                }
            }
        }
    }
}