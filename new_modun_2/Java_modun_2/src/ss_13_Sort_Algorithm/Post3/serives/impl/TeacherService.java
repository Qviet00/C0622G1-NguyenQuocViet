package ss_13_Sort_Algorithm.Post3.serives.impl;
import ss_13_Sort_Algorithm.Post3.model.Teacher;
import ss_13_Sort_Algorithm.Post3.serives.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Hai TD", "1/1/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "Cong TT", "2/02/1995", "nam", "tutor"));
        teachers.add(new Teacher(2, "Chanh TT", "3/03/1985", "nam", "tutor"));
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
        System.out.println("Add ok");
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacherID();
        if (teacher == null) {
            System.out.println("Not fond");
        } else {
            System.out.println("Ok detele ID " + teacher.getId() );
            System.out.println("1 . Yes");
            System.out.println("2 . No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Detele ok");

            }
        }
    }

    @Override
    public void searchTeacher() {
        while (true) {
            System.out.println("1. Search ID");
            System.out.println("2. Search name");
            System.out.println("3. Cancel");
            System.out.println("Enter option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Teacher teacher = this.findTeacherID();
                    if (teacher == null) {
                        System.out.println("Not fond");
                    } else {
                        System.out.println(teacher);
                    }
                    break;
                case 2:
                    Teacher teacher1 = this.findTeacherName();
                    if (teacher1 == null) {
                        System.out.println("Not fond");
                    } else {
                        System.out.println(teacher1);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Reset");
                    break;
            }
        }
    }

    private Teacher findTeacherName() {
        System.out.println("Reset name");
        String name = scanner.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher findTeacherID() {
        System.out.print("Enter  id: ");
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
            System.out.print("Enter id: ");
            id = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("Reset id");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter sex: ");
        String sex = scanner.nextLine();
        System.out.print("Enter qualification: ");
        String qualification = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, sex, qualification);
        return teacher;
    }
}