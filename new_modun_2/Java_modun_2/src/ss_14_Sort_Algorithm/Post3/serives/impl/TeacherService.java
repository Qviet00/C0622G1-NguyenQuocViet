package ss_14_Sort_Algorithm.Post3.serives.impl;

import ss_14_Sort_Algorithm.Post3.model.Teacher;
import ss_14_Sort_Algorithm.Post3.serives.ITeacherService;

import java.util.*;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Hai TD", "1/1/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "Cong TT", "2/02/1995", "nam", "tutor"));
        teachers.add(new Teacher(3, "Chanh TT", "3/03/1985", "nam", "tutor"));
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
    public void deleteTeacher() {
        Teacher teacher = this.findTeacherID();
        if (teacher == null) {
            System.out.println("Not fond");
        } else {
            System.out.println("Ok detele ID " + teacher.getId());
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
            System.out.println("1.Search ID");
            System.out.println("2.Search name");
            System.out.println("3.Cancel");
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

    @Override
    public void sortTeacher() {
//        while (true) {
//            System.out.println("1.Sort ID");
//            System.out.println("2.Sort Name");
//            System.out.println("3.Cancel");
//            System.out.print("Enter option: ");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1: {
//                    teachers.sort(new sortID());
//                    for (Teacher teacher : teachers) System.out.println(teacher);
//                    break;
//                }
//                case 2: {
//                    teachers.sort(new sortName());
//                    for (Teacher teacher : teachers) System.out.println(teacher);
//                    break;
//                }
//                case 3:
//                    return;
//                default:
//                    System.out.println("Reset");
//                    break;
//            }
//        }
        boolean isSwap = true;
        Teacher temp;
        for (int i = 0; i < teachers.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(j));
                    teachers.set(j, temp);
                }
            }
        }
        displayAllTeacher();
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
        return new Teacher(id, name, dateOfBirth, sex, qualification);
    }
//
//    private static class sortName implements Comparator<Teacher> {
//
//        @Override
//        public int compare(Teacher o1, Teacher o2) {
//            return o1.getName().compareTo(o2.getName());
//        }
//    }
//
//    private static class sortID implements Comparator<Teacher> {
//
//        @Override
//        public int compare(Teacher o1, Teacher o2) {
//            return Double.compare(o1.getId(), o2.getId());
//        }
//    }
}