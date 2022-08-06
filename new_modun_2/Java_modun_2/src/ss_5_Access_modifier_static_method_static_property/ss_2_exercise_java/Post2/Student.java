package ss_5_Access_modifier_static_method_static_property.ss_2_exercise_java.Post2;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name = name;
        this.classes = classes;
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
