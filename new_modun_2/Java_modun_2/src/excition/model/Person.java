package excition.model;

public class Person {
    private double id;
    private String name;
    private String birthday;
    private String grander;

    public Person() {
    }

    public Person(double id, String name, String birthday, String grander) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.grander = grander;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGrander() {
        return grander;
    }

    public void setGrander(String grander) {
        this.grander = grander;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",getId(),getName(),getBirthday(),getGrander());
    }
}
