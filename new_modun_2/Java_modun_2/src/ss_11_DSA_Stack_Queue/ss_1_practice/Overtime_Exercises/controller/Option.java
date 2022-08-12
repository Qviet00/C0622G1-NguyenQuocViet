package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.controller;

import java.util.Scanner;

public class Option {
    private final Scanner src = new Scanner(System.in);
    StudentCtr studentCtr = new StudentCtr();
    TeacherCtr teacherCtr = new TeacherCtr();

    public void optionManagement() {
        while (true) {
            System.out.print("1. Option teacher \n");
            System.out.print("2. Option student  \n");
            System.out.print("Enter function: ");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                teacherCtr.optionTeacher();
            } else if (choice == 2) {
                studentCtr.optionStudent();
            } else {
                System.out.println("Re-enter function?");
            }
        }
    }
}
