package ss_14_Sort_Algorithm.Post3.controller;

import ss_14_Sort_Algorithm.Post3.serives.ITeacherService;
import ss_14_Sort_Algorithm.Post3.serives.impl.TeacherService;

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
            int choice2 = Integer.parseInt(scanner.nextLine());
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
}
