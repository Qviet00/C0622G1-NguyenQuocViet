package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student(int id, String name, String dateOfBirth, String sex, String nameClass, double point) {
    }

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student(int id, String name, String dateOfBirth, String sex, double point, String nameClass) {
        super(id, name, dateOfBirth, sex);
        this.point = point;
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" + "Id: " + getId() + ", Name: " + getName() + ", DateOfBirth: " + getBirthday() +
                ", Sex: " + getSex() + ", Point: " + point + ", NameClass: " + nameClass +
                "} ";
    }
}
