package ss_14_Sort_Algorithm.Post3.serives.impl;

import ss_14_Sort_Algorithm.Post3.model.Student;
import ss_14_Sort_Algorithm.Post3.serives.IStudentService;

import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Trần Văn Nam", "12/12/1999", "nam", "C06G1", 1));
        students.add(new Student(2, "Nguyễn Cát Yên", "11/11/1998", "nu", "C06G1", 2));
        students.add(new Student(3, "Nguyễn Thanh Hải", "10/10/1997", "nam", "C06G1", 3));
    }


    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Add ok");
    }

    @Override
    public void displayAllStudent() {
        System.out.println("-Danh sách đây bạn:");
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    @Override
    public void deteleStudent() {
        Student student = this.findStudentID();
        if (student == null) {
            System.out.println("Not fond");
        } else {
            System.out.println("Ok detele " + student.getId());
            System.out.println("1 . Yes");
            System.out.println("2 .No");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Detele ok");
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
            System.out.println("2. Search NAME");
            System.out.println("3. Cancel");
            System.out.println("Enter option");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Student student = this.findStudentID();
                    if (student == null) {
                        System.out.println("Not fond");
                    } else {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    Student student1 = this.findStudentName();
                    if (student1 == null) {
                        System.out.println("Not fond");
                    } else {
                        System.out.println(student1);
                    }
                    break;
                case 3:
                    return;
            }
        }
    }

    @Override
    public void sortStudent() {
//        while (true) {
//            System.out.println("1.Sort ID");
//            System.out.println("2.Sort Name");
//            System.out.println("3.Cancel");
//            System.out.print("Enter option: ");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1: {
//                    students.sort(new sortID());
//                    for (Student student : students) System.out.println(student);
//                    break;
//                }
//                case 2: {
//                    students.sort(new sortName());
//                    for (Student student : students) System.out.println(student);
//                }
//                break;
//                case 3:
//                    return;
//                default:
//                    System.out.println("Reset");
//                    break;
//            }
//        }
        boolean isSwap = true;
        Student temp;
        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    temp = students.get(j + 1);
                    students.set(j + 1, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        displayAllStudent();
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
        System.out.print("Enter birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter sex: ");
        System.out.print("Enter poit: ");
        String sex = scanner.nextLine();
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter name claas: ");
        String nameClass = scanner.nextLine();
        return new Student(id, name, dateOfBirth, sex, nameClass, point);
    }

//    private static class sortName implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.getName().compareTo(o2.getName());
//        }
//    }
//
//    private static class sortID implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            return Double.compare(o1.getId(), o2.getId());
//        }
//    }
//

}
