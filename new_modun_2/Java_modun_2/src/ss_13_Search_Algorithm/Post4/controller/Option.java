package ss_13_Search_Algorithm.Post4.controller;

import java.util.Scanner;

public class Option {
    Scanner scanner = new Scanner(System.in);
    StudentOption studentController = new StudentOption();
    TeacherOption teacherController = new TeacherOption();

    public void option() {
        while (true) {
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.print("Option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherController.menuManagementTeacher();
            } else if (choice == 2) {
                studentController.menuManagementStudent();
            }else {
                System.out.println("reset option");
            }
        }
    }
}
