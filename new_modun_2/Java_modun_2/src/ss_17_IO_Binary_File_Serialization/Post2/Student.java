package ss_17_IO_Binary_File_Serialization.Post2;

public class Student implements java.io.Serializable{
    private int id;
    private String name;
    private String clas;

    public Student() {
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

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name, String clas) {
        this.id = id;
        this.name = name;
        this.clas = clas;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",getId(),getName(),getClas());
    }
}
