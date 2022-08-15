package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.impl;

import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.model.Teacher;
import ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.serivese.IsSTeacherSev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherSev implements IsSTeacherSev {
    private static final Scanner src = new Scanner(System.in);
    private static final List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Hai TT", "1/1/1990", "Nam", "CSS"));
        teachers.add(new Teacher(2, "Cong NT", "2/2/1990", "Nam", "java"));
        teachers.add(new Teacher(2, "Ha TTT", "3/3/2000", "Nu", "Job"));
    }

    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        for (Teacher teacherOne : teachers
        ) {
            System.out.println(teacherOne);
        }
        System.out.println("Add teacher ok ");
    }

    private Teacher infoTeacher() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(src.nextLine());
        System.out.print("Enter Name: ");
        String name = src.nextLine();
        System.out.print("Enter birthday: ");
        String BirthDay = src.nextLine();
        System.out.print("Enter sex: ");
        String sex = src.nextLine();
        System.out.print("Enter Specialize: ");
        String qualification = src.nextLine();
        return new Teacher(id, name, BirthDay, sex, qualification);
    }

    public void displayAllTeacher() {
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok" + teacher.getId());
            System.out.println("1 . OK");
            System.out.println("2 . Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Delete ok");
            }
        }
    }

    private Teacher findTeacher() {
        System.out.print("Enter id delete: ");
        int id = Integer.parseInt(src.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}

