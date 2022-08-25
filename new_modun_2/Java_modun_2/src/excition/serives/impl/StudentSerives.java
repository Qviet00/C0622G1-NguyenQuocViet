package excition.serives.impl;

import excition.Until.Checked;
import excition.Until.ReadFile;
import excition.Until.WriteFile;
import excition.model.Student;
import excition.serives.IsStudent;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSerives implements IsStudent {
    public static final String SRC_EXCITION_DATA_STUDENT_CSV = "src/excition/data/student.csv";
    private Scanner src = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    @Override
    public void disPlayStudent() {
        students = readFileStudent();
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    @Override
    public void addStudents() {
        Student student=this.infoStudent();
        List<Student> studentList=new ArrayList<>();
        studentList.add(student);
        WriteFile.writeFile(SRC_EXCITION_DATA_STUDENT_CSV,true,convertListStudentToListString(studentList));
        for (Student st : students
        ) {
            System.out.println(st);
        }
        System.out.println("Thêm mới thành công.");

    }

    @Override
    public void eDitStudent() {

    }

    @Override
    public void removeStudent() {

    }

    @Override
    public void sortStudents() {

    }

    @Override
    public void searchstudents() {

    }

    private List<Student> readFileStudent() {
        List<String> studentList = ReadFile.readFile(SRC_EXCITION_DATA_STUDENT_CSV);
        List<Student> students = new ArrayList<>();
        if (studentList.size() == 0) {
            System.out.println("Dữ liệu trong file không có.");
            return null;
        } else {
            String[] readOfStudent;
            Student student;
            for (int i = 0; i < studentList.size(); i++) {
                readOfStudent = studentList.get(i).split(",");
                if (readOfStudent.length == 6) {
                    student = new Student(Double.parseDouble(readOfStudent[0]), readOfStudent[1],
                            readOfStudent[2], readOfStudent[3], readOfStudent[4],
                            Double.parseDouble(readOfStudent[5]));
                    students.add(student);
                }
            }
            return students;
        }
    }

    private String convertStudentToString(Student student) {
        return student.getId() + "," + student.getName() + "," + student.getBirthday() + "," + student.getPoint() + "," + student.getNameClass();
    }
    private List<String> convertListStudentToListString(List<Student> students) {
        List<String> strings = new ArrayList<>();
        for (Student student : students) {
            strings.add(convertStudentToString(student));
        }
        return strings;
    }

    private Student infoStudent() {
        students = this.readFileStudent();
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Checked.CheckedOne(id);
                boolean check = true;
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.print("ID bị trùng,Nhập lại id: ");
                        check = false;
                        break;
                    }
                }
                if (check) break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại id");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("Nhập tên: ");
                name = (src.nextLine());
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ("\\d +".matches(str + name.charAt(i))) {
                        throw new UntilException("Tên bạn nhập ko đúng");
                    }
                }

                break;
            } catch (UntilException e) {
                System.out.println(e.getMessage());
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh: ");
                dateOfBirth = src.nextLine();
                if (!dateOfBirth.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    throw new UntilException("Dữ liệu không đúng ,nhập lại");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2022) {
                    throw new UntilException("Dữ liệu không đúng ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String sex;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                sex = src.nextLine();
                if (!sex.equals("nam") && (!sex.equals("nu"))) {
                    throw new UntilException("Sai rồi, nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(src.nextLine());
                if (point < 0 || point > 100) {
                    throw new UntilException("Điểm bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String nameClass;
        while (true) {
            try {
                System.out.print("Nhập tên lớp: ");
                nameClass = src.nextLine();
                if ("\\D+\\d+\\d+\\d+\\d+\\D+\\d".matches(nameClass)) {
                    throw new UntilException("Tên lớp không đúng");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Student(id, name, dateOfBirth, sex, nameClass, point);

    }
    private Student findStudentName() {
        System.out.println("Nhập tên cần xóa: ");
        String name = src.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }
    public Student findStudent() {
        students = this.readFileStudent();
        System.out.print("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(src.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

}

