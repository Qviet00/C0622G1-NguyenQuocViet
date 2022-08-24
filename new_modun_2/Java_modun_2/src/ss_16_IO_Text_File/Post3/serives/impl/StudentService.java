package ss_16_IO_Text_File.Post3.serives.impl;

import ss_16_IO_Text_File.Post3.model.Student;
import ss_16_IO_Text_File.Post3.serives.IStudentService;
import ss_16_IO_Text_File.Post3.utils.Checked;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.*;
import java.util.*;

public class StudentService implements IStudentService {
    public static final String SRC_SS_16_IO_TEXT_FILE_POST_3_DATA_STUDENT = "src/ss_16_IO_Text_File/Post3/data/student";
    private static Scanner src = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    Checked checked = new Checked();

    static {
        students.add(new Student(1, "Trần Văn Nam", "12/12/1999", "nam", "C06G1", 1));
        students.add(new Student(2, "Nguyễn Cát Yên", "11/11/1998", "nu", "C06G1", 2));
        students.add(new Student(3, "Nguyễn Thanh Hải", "10/10/1997", "nam", "C06G1", 3));
    }


    @Override
    public void addStudent() throws IOException {
        List<Student> students = readFile();
        Student student= this.infoStudent();
        students.add(student);
        writeFile(students);
    }

    private void writeFile(List<Student> students) throws IOException {
        File file = new File(SRC_SS_16_IO_TEXT_FILE_POST_3_DATA_STUDENT);
       FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Student student : students) {
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    private static List<Student> readFile() throws IOException {
        File file = new File(SRC_SS_16_IO_TEXT_FILE_POST_3_DATA_STUDENT);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Student> students = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Student student = new Student();
            student.setId(Integer.parseInt(info[0]));
            student.setName(info[1]);
            student.setDateOfBirth((info[2]));
            student.setSex((info[3]));
            student.setNameClass(info[4]);
            student.setPoint(Double.parseDouble((info[5])));
            students.add(student);
            System.out.println(line);
        }
        bufferedReader.close();
        return  students;
    }

    @Override
    public void displayAllStudent() throws IOException {
        students=readFile();
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
            System.out.println("Not found");
        } else {
            System.out.println("Muốn xóa: " + student.getId());
            System.out.println("1 .Yes");
            System.out.println("2 .No");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa ok");
            }
        }
    }

    private Student findStudentID() {
        System.out.print("Nhập id: ");
        double id = 0;
        checked.CheckedOne(id);

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    private Student findStudentName() {
        System.out.println("Nhập tên: ");
        String name = src.nextLine();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                return student;
            }
        }
        return null;
    }

    public void searchStudent() {

        while (true) {
            System.out.println("1. Tìm  ID");
            System.out.println("2. Tìm NAME");
            System.out.println("3. Hủy");
            System.out.println("Nhập lựa chọn:");
            int choice = 0;
            choice = (int) checked.Checked(choice, 4);
            switch (choice) {
                case 1:
                    Student student = this.findStudentID();
                    if (student == null) {
                        System.out.println("Not found");
                    } else {
                        System.out.println(student);
                    }
                    break;
                case 2:
                    Student student1 = this.findStudentName();
                    if (student1 == null) {
                        System.out.println("Not found");
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
    public void sortStudent() throws IOException {
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



    private Student infoStudent() {
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id= checked.CheckedOne(id);
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
}
