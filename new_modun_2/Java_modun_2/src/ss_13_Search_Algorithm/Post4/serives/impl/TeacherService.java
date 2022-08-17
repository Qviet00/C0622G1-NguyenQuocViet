package ss_13_Search_Algorithm.Post4.serives.impl;
import ss_13_Search_Algorithm.Post4.serives.ITeacherService;
import ss_13_Search_Algorithm.Post4.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Hai TD", "1/1/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "Cong TT", "2/02/1995", "nam", "tutor"));
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("add ok");
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacherID();
        if (teacher == null) {
            System.out.println("not fond");
        } else {
            System.out.println("ok detele ID " + teacher.getId() + " không?");
            System.out.println("1 . yes");
            System.out.println("2 . no");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("detele ok");

            }
        }
    }

    @Override
    public void searchTeacher() {
        while (true) {
            System.out.println("1. search ID");
            System.out.println("2. search name");
            System.out.println("3. cancel");
            System.out.println("enter option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Teacher teacher = this.findTeacherID();
                    if (teacher == null) {
                        System.out.println("not fond");
                    } else {
                        System.out.println(teacher);
                    }
                    break;
                case 2:
                    Teacher teacher1 = this.findTeacherName();
                    if (teacher1 == null) {
                        System.out.println("not fond");
                    } else {
                        System.out.println(teacher1);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("reset");
                    break;
            }
        }
    }

    private Teacher findTeacherName() {
        System.out.println("reset name");
        String name = scanner.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                return teacher;
            }
        }
        return null;
    }



    private Teacher findTeacherID() {
        System.out.print("enter  id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher infoTeacher() {
        int id;
        do {
            System.out.print("enter id: ");
            id = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("reser id");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);
        System.out.print("enter name: ");
        String name = scanner.nextLine();
        System.out.print("enter birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("enter sex: ");
        String sex = scanner.nextLine();
        System.out.print("enter qualification: ");
        String qualification = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, sex, qualification);
        return teacher;
    }
}