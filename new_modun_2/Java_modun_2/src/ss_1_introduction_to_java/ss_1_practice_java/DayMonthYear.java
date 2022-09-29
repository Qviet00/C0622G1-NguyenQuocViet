package ss_1_introduction_to_java.ss_1_practice_java;

import java.util.Scanner;

public class DayMonthYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tháng cần kiểm tra:");
        int month = scanner.nextInt();

        String daysInMonth = switch (month) {
            case 2 -> "28 or 29";
            case 1, 3, 5, 7, 8, 10, 12 -> "31";
            case 4, 6, 9, 11 -> "30";
            default -> "";
        };

        if (!daysInMonth.equals("")) System.out.printf("The month '%d' has %s days!", month, daysInMonth);
        else System.out.print("Invalid input!");
    }
}
