package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.impl;

import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.model.Student;
import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.IsStudentSev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSev implements IsStudentSev {
    private final Scanner src = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Van Nam", "2/2/1997", "Nam", 8, "C0622G1"));
        students.add(new Student(2, "Nha Uyen", "3/3/1997", "Nu", 9, "C0622G1"));
        students.add(new Student(3, "Hoang Duy", "4/4/1997", "Nam", 7, "C0622G1"));

    }

    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Add Student ok");
        for (Student studentOne : students
        ) {
            System.out.println(studentOne);
        }

    }

    private Student infoStudent() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(src.nextLine());
        System.out.print("Enter Name: ");
        String name = src.nextLine();
        System.out.print("Enter birthday: ");
        String dateOfBirth = src.nextLine();
        System.out.print("Enter Sex: ");
        String sex = src.nextLine();
        System.out.print("Enter Point: ");
        double point = Double.parseDouble(src.nextLine());
        System.out.print("Enter Name Class: ");
        String nameClass = src.nextLine();
        return new Student(id, name, dateOfBirth, sex,point, nameClass);
    }

    public void displayAllStudent() {

        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok  " + student.getId());
            System.out.println("1 .OK");
            System.out.println("2 .Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Delete ok");
            }
        }

    }

    private Student findStudent() {
        System.out.print("Enter id delete: ");
        int id = Integer.parseInt(src.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
