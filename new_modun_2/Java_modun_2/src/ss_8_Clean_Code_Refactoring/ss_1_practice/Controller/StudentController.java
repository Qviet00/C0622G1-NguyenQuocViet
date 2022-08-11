package ss_8_Clean_Code_Refactoring.ss_1_practice.Controller;

import ss_8_Clean_Code_Refactoring.ss_1_practice.Serivese.IStudentService;
import ss_8_Clean_Code_Refactoring.ss_1_practice.Serivese.StudentService;

import java.util.Scanner;



public class StudentController {
    public void displayMenu() {

        Scanner scanner = new Scanner(System.in);
        int choose;

        IStudentService iStudentService = new StudentService();
        while (true) {
            System.out.println("Mời bạn chọn chức năng");
            System.out.println("1. Tạo mới sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Kết thúc");

            System.out.print("Hãy chọn chức năng: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    //Làm gì đó
                    break;
                case 2:
                    iStudentService.showAll();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
            }

        }

    }
}
