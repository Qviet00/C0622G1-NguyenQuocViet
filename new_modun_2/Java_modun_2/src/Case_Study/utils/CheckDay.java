package Case_Study.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckDay {
    public static  String checkDay(String day){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập ngày sinh theo dd/MM/yyyy: ");
        day= scanner.nextLine();
        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate date = null;
        do {
            try {
                date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(date, dateNow);
                if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                    break;
                }
                check = false;
                System.out.print("Sai rồi nhập lại: ");
            } catch (DateTimeParseException e) {
                System.out.print("Sai rồi nhập lại: ");
                check = false;
            }
        } while (!check);

        return day;
    }


}
