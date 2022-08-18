package ss_13_Sort_Algorithm.Post3.controller;
import ss_13_Sort_Algorithm.Post3.serives.ITeacherService;
import ss_13_Sort_Algorithm.Post3.serives.impl.TeacherService;

import java.util.Scanner;

public class TeacherOption {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherService teacherService = new TeacherService();

    public void optionTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("hello");
            System.out.println("1.display teacher");
            System.out.println("2. add teacher");
            System.out.println("3.detele teacher");
            System.out.println("4.search teacher");
            System.out.println("5. Exit");
            System.out.print("option 1 -> 5: ");
            int choice2 = Integer.parseInt(scanner.nextLine());
            switch (choice2) {
                case 1:
                    teacherService.displayAllTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.removeTeacher();
                    break;
                case 4:
                    teacherService.searchTeacher();
                case 5:
                    return;
                default:
                    System.out.println("no");
            }
        }
    }
}
