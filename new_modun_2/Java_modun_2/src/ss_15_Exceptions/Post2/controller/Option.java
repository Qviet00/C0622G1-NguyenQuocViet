package ss_15_Exceptions.Post2.controller;

import ss_15_Exceptions.utils.exception.UntilException;

import java.util.Scanner;

public class Option {
    StudentOption studentController = new StudentOption();
    TeacherOption teacherController = new TeacherOption();

    public void option() {
        while (true) {
            System.out.println("1. Teacher.");
            System.out.println("2. Student.");
            System.out.print("* Nhập lựa chọn theo số:  ");
            double choice = 0;
            choice = checkEdgeOne(choice);
            if (choice == 1) {
                teacherController.optionTeacher();
            } else if (choice == 2) {
                studentController.optionStudent();
            } else {
                System.out.println("Không đúng,Nhập lại: ");
            }
        }
    }

    public static double checkEdgeOne(double i) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i < 0 || i > 2) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn 3, nhập lại nge: ");
                }
                break;
            } catch (UntilException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.print("Bạn nhập không phải là số, nhập lại nghe: ");
            }
        }
        return i;
    }
}
