package excition.model;

public class Student extends Person{
    private String nameClass;
    private double point;

    public Student() {
    }

    public Student(String nameClass, double point) {
        this.nameClass = nameClass;
        this.point = point;
    }

    public Student(double id, String name, String birthday, String grander, String nameClass, double point) {
        super(id, name, birthday, grander);
        this.nameClass = nameClass;
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getBirthday(),this.getGrander(),getNameClass(),getPoint());
    }
}
