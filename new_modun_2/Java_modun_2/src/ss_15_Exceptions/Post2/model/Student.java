package ss_15_Exceptions.Post2.model;

import ss_16_IO_Text_File.Post3.model.Person;

public class Student extends Person {
    private double point;
    private String nameClass;

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

    public Student(){}
    public Student(int i, String s, double v) {
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getDateOfBirth(),this.getSex(),this.nameClass,this.point);
    }

    public Student(double point, String nameClass) {
        this.point = point;
        this.nameClass = nameClass;
    }


    public Student(int id, String name, String dateOfBirth, String sex, String nameClass, double point) {
        super(id, name, dateOfBirth, sex);
        this.point = point;
        this.nameClass = nameClass;
    }
}
