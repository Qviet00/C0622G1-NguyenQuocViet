package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.controller;

import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.IsSTeacherSev;;
import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.impl.TeacherSev;

import java.util.Scanner;

public class TeacherCtr {
    private static Scanner src = new Scanner(System.in);
    IsSTeacherSev isSteacherSev = new TeacherSev();

    public void optionTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Hello");
            System.out.println("1. Display teacher");
            System.out.println("2. Add teacher");
            System.out.println("3. Delete teacher");
            System.out.println("4. Cancel");
            System.out.print("Import 1->4: ");
            int choice2 = Integer.parseInt(src.nextLine());
            switch (choice2) {
                case 1:
                    isSteacherSev.displayAllTeacher();
                    break;
                case 2:
                    isSteacherSev.addTeacher();
                    break;
                case 3:
                    isSteacherSev.removeTeacher();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong");
            }

        }
    }

}
