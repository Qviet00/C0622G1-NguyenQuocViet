package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.controller;

import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.IsStudentSev;
import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.impl.StudentSev;

import java.util.Scanner;

public class StudentCtr {
    private static final Scanner src = new Scanner(System.in);
    IsStudentSev isStudentSev = new StudentSev();
    public void optionStudent() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Hello");
            System.out.println("1.Display student");
            System.out.println("2. Add student");
            System.out.println("3. Delete");
            System.out.println("4. Cancel");
            System.out.print("Import 1->4: ");
            int choice1 = Integer.parseInt(src.nextLine());
            switch (choice1) {
                case 1:
                    isStudentSev.displayAllStudent();
                    break;
                case 2:
                    isStudentSev.addStudent();
                    break;
                case 3:
                    isStudentSev.removeStudent();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong");
            }

        }
    }
}
