package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.model;

public class Teacher extends Person {
    private String Specialize;

    public Teacher() {
    }

    public Teacher(String specialize) {
        Specialize = specialize;
    }

    public Teacher(int id, String name, String dateOfBirth, String sex, String specialize) {
        super(id, name, dateOfBirth, sex);
        Specialize = specialize;
    }

    public String getSpecialize() {
        return Specialize;
    }

    public void setSpecialize(String specialize) {
        Specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id: " + getId() + ", Name: " + getName() + ", DateOfBirth: " + getBirthday() +
                ", Sex: " + getSex() + " ,Specialize: " + getSpecialize() +
                "} ";
    }
}
