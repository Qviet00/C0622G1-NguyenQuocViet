package ss_8_Clean_Code_Refactoring.ss_1_practice.Serivese;
import ss_8_Clean_Code_Refactoring.ss_1_practice.Model.Student;

public class StudentService implements IStudentService {
    static Student[] students;
    static int size;

    static {
        students = new Student[100];
        students[0] = new Student(1, "Minh Châu", 2);
        students[1] = new Student(2, "Mậu Hoàng", 0.5);
        students[2] = new Student(3, "Hoàng Duy", 1.5);
        size = 3;
    }

    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.printf("Thông tin sinh viên thứ %d\n", i + 1);
            System.out.println(students[i].toString());
        }
    }
}