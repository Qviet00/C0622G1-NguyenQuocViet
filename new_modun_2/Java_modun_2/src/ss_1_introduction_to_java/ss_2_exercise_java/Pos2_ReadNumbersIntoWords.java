package ss_1_introduction_to_java.ss_2_exercise_java;

import java.util.Scanner;

public class Pos2_ReadNumbersIntoWords {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập số đi bạn:");
        int number = src.nextInt();
        String hundreds = null;
        String dozens = null;
        String unit = null;

        if (number < 1001 && number >= 0) {
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
                    dozens = "and Fourty";
                    break;
                case 5:
                    dozens = "and Fitty";
                    break;
                case 6:
                    dozens = "and Sixty";
                    break;
                case 7:
                    dozens = "and Sevennty";
                    break;
                case 8:
                    dozens = "and Eightty";
                    break;
                case 9:
                    dozens = "and Ninety";
                    break;
            }
            switch (unit1) {
                case 0:
                    unit = "";
                    break;
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
                    unit = "Fourt";
                    break;
                case 5:
                    unit = "Five";
                    break;
                case 6:
                    unit = "Six";
                    break;
                case 7:
                    unit = "Sevent";
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

