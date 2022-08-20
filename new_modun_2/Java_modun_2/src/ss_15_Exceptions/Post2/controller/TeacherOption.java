package ss_15_Exceptions.Post2.controller;

import ss_15_Exceptions.Post2.serives.ITeacherService;
import ss_15_Exceptions.Post2.serives.impl.TeacherService;
import ss_15_Exceptions.utils.exception.UntilException;

import java.util.Scanner;

public class TeacherOption {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherService teacherService = new TeacherService();

    public void optionTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Hello");
            System.out.println("1.Display teacher");
            System.out.println("2.Add teacher");
            System.out.println("3.Detele teacher");
            System.out.println("4.Search teacher");
            System.out.println("5.Sort teacher");
            System.out.println("6.Exit");
            System.out.print("* Nhập lựa chọn theo số: 1 -> 6. ");
            int choice2 = 0;
            choice2 = (int) checkEdgeOne(choice2);
            switch (choice2) {
                case 1:
                    teacherService.displayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.deleteTeacher();
                    break;
                case 4:
                    teacherService.searchTeacher();
                case 5:
                    teacherService.sortTeacher();
                case 6:
                    return;
                default:
                    System.out.println("No");
            }
        }
    }

    public static double checkEdgeOne(double i) {
        Scanner src = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(src.nextLine());
                if (i < 0 || i > 6) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn 6, nhập lại nge: ");
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
