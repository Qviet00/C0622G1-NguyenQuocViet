package ss_13_Search_Algorithm.Post4.serives.impl;

import ss_13_Search_Algorithm.Post4.serives.IStudentService;
import ss_13_Search_Algorithm.Post4.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Tran Van Nam", "12/12/1999", "nam", "C06G1", 1));
        students.add(new Student(2, "Nguyen Cat Yen", "11/11/1198", "nu", "C06G1", 2));
    }


    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("add ok");
    }

    @Override
    public void displayAllStudent() {
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudentID();
        if (student == null) {
            System.out.println("not fond");
        } else {
            System.out.println("ok detele " + student.getId() + " không?");
            System.out.println("1 . yes");
            System.out.println("2 .no");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("detele ok");
            }
        }
    }

    private Student findStudentID() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void searchStudent() {

        while (true) {
            System.out.println("1. Search ID");
            System.out.println("2. search NAME");
            System.out.println("3. Cancel");
            System.out.println("Enter option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = this.findStudentID();
                    if (student == null) {
                        System.out.println("not fond");
                    } else {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    Student student1 = this.findStudentName();
                    if (student1 == null) {
                        System.out.println("not fond");
                    } else {
                        System.out.println(student1);
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

    private Student findStudentName() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }

    private Student infoStudent() {
        int id;
        do {
            System.out.print("Enter id: ");
            id = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("ID not fond");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("enter birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("enter sex: ");
        String sex = scanner.nextLine();
        System.out.print("enter poit: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("enter name claas: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, sex, nameClass, point);
        return student;
    }
}
