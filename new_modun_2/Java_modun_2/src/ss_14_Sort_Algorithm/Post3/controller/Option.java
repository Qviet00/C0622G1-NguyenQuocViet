package ss_14_Sort_Algorithm.Post3.controller;

import java.util.Scanner;

public class Option {
    Scanner scanner = new Scanner(System.in);
    StudentOption studentController = new StudentOption();
    TeacherOption teacherController = new TeacherOption();

    public void option() {
        while (true) {
            System.out.println("1. Teacher.");
            System.out.println("2. Student.");
            System.out.print(" Enter option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherController.optionTeacher();
            } else if (choice == 2) {
                studentController.optionStudent();
            }else {
                System.out.println("Reset option");
            }
        }
    }
}
