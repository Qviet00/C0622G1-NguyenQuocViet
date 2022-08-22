package ss_16_IO_Text_File.Post3.controller;

import ss_16_IO_Text_File.Post3.utils.Checked;

import java.io.IOException;

public class Option {
    StudentOption studentController = new StudentOption();
    TeacherOption teacherController = new TeacherOption();

    public void option() throws IOException {
        while (true) {
            System.out.println("1. Teacher.");
            System.out.println("2. Student.");
            System.out.print("* Nhập lựa chọn theo số:  ");
            double choice = 0;
            Checked checked = new Checked();
            choice=checked.Checked(choice, 3);
            if (choice == 1) {
                teacherController.optionTeacher();
                break;
            } else if (choice == 2) {
                studentController.optionStudent();
                break;
            }
        }
    }
}