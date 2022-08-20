package ss_15_Exceptions.Post2.controller;

import ss_15_Exceptions.Post2.serives.IStudentService;
import ss_15_Exceptions.Post2.serives.impl.StudentService;
import ss_15_Exceptions.utils.exception.UntilException;

import java.util.Scanner;

public class StudentOption {
    private static Scanner scanner = new Scanner(System.in);
    private IStudentService studentService = new StudentService();

    public void optionStudent() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("* Hello *");
            System.out.println("1.Display student");
            System.out.println("2.Add student");
            System.out.println("3.Detele student: ");
            System.out.println("4.Search student: ");
            System.out.println("5.Sort student: ");
            System.out.println("6.Exit");
            System.out.print("* Nhập lựa chọn theo số( 1 -> 6 ): ");
            int choice1 = 0;
            choice1 = (int) checkEdgeOne(choice1);
            switch (choice1) {
                case 1:
                    studentService.displayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.deteleStudent();
                    break;
                case 4:
                    studentService.searchStudent();
                case 5:
                    studentService.sortStudent();
                    break;
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
                i = Integer.parseInt(src.nextLine());
                if (i < 0 || i > 6) {
                    throw new UntilException("Số nhập phải lớn hơn 0 và nhỏ hơn 7, nhập lại nge: ");
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