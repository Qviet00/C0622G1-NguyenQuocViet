package ss_11_DSA_Stack_Queue.ss_1_practice.Overtime_Exercises.model;

public abstract class Person {
    private int id;
    private String name;
    private String Birthday;
    private String sex;

    public Person() {
    }

    public Person(int id, String name, String Birthday, String sex) {
        this.id = id;
        this.name = name;
        this.Birthday = Birthday;
        this.sex = sex;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        this.Birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
