package ss_14_Sort_Algorithm.Post3.controller;

import ss_14_Sort_Algorithm.Post3.serives.IStudentService;
import ss_14_Sort_Algorithm.Post3.serives.impl.StudentService;

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
            int choice1 = Integer.parseInt(scanner.nextLine());
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
}
