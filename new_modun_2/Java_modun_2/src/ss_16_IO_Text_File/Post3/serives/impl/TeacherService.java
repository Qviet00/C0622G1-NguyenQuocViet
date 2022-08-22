package ss_16_IO_Text_File.Post3.serives.impl;

import ss_16_IO_Text_File.Post3.model.Teacher;
import ss_16_IO_Text_File.Post3.serives.ITeacherService;
import ss_16_IO_Text_File.Post3.utils.Checked;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.*;
import java.util.*;

public  class TeacherService implements ITeacherService {
    private static Scanner src = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    Checked checked = new Checked();

    static {
        teachers.add(new Teacher(1, "Hai TD", "1/1/1990", "nam", "tutor"));
        teachers.add(new Teacher(2, "Cong TT", "2/02/1995", "nam", "tutor"));
        teachers.add(new Teacher(3, "Chanh TT", "3/03/1985", "nam", "tutor"));
    }

    @Override
    public void displayAllTeacher() throws IOException {
        teachers=readFile();
        System.out.println("-Danh sách đây bạn:");
        for (Teacher student : teachers
        ) {
            System.out.println(student);
        }


    }

    @Override
    public void addTeacher() throws IOException {
        List<Teacher> teachers = readFile();
        Teacher teacher= this.infoTeacher();
        teachers.add(teacher);
        writeFile(teachers);

    }

    private void writeFile(List<Teacher> teachers) throws IOException {
        File file = new File("src/ss_16_IO_Text_File/Post3/data/teachear");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Teacher teacher : teachers) {
            bufferedWriter.write(teacher.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    private static List<Teacher> readFile() throws IOException {
        File file = new File("src/ss_16_IO_Text_File/Post3/data/teachear");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Teacher> teachers = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            Teacher teacher = new Teacher();
            teacher.setId(Integer.parseInt(info[0]));
            teacher.setName(info[1]);
            teacher.setDateOfBirth((info[2]));
            teacher.setSex((info[3]));
            teacher.setQualification(info[4]);
           teachers.add(teacher);
            System.out.println(line);
        }
        bufferedReader.close();
        return  teachers;
    }

    @Override
    public void displayAllStudent() throws IOException {
        teachers=readFile();
        System.out.println("-Danh sách đây bạn:");
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
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
            int choice = 0;
            checked.Checked(choice, 3);
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
            int choice = 0;
            choice= (int) checked.Checked(choice,4);
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
    public void sortTeacher() throws IOException {
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
        String name = src.nextLine();
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher findTeacherID() {
        System.out.print("Enter  id: ");
        int id = 0;
        checked.Checked(id, 1000000000);
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher infoTeacher() {
        int id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id: ");
                id = Integer.parseInt(src.nextLine());
                boolean check = true;
                for (Teacher teacher : teachers) {
                    if (teacher.getId() == id) {
                        System.out.println("ID bị trùng, mời bạn nhập lại id");
                        id = Integer.parseInt(src.nextLine());
                        check = false;
                        break;
                    }
                }
                if (check) break;
            } catch (NumberFormatException e) {
                System.out.println("Mời bạn nhập lại id");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = (src.nextLine());
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ("\\d+".matches(str + name.charAt(i))) {
                        throw new UntilException("Tên bạn nhập ko hợp lệ");
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
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = src.nextLine();
                if ("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d".matches(dateOfBirth)) {
                    throw new UntilException("Dữ liệu không đúng định dạng");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2022) {
                    throw new UntilException("Dữ liệu không đúng định dạng");
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
                    throw new UntilException("Dữ liệu bạn nhập không hợp lệ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String qualification;
        String qualificationStr;
        while (true) {
            try {
                System.out.print("Mời bạn nhập trình độ chuyên môn: ");
                qualification = src.nextLine();
                for (int i = 0; i < name.length(); i++) {
                    qualificationStr = "";
                    if ((qualificationStr + name.charAt(i)).matches("\\d+")) {
                        throw new UntilException("Dữ liệu bạn nhập ko hợp lệ");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Teacher(id, name, dateOfBirth, sex, qualification);
    }
}