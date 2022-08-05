package ss_5_Access_modifier_static_method_static_property.ss_2_exercise_java.Post2;

public class Main {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Nguyễn Văn Á");
        student.setClasses("C0622G1");
        System.out.println(student);
        student.setName("Nguyễn Văn Cê");
        student.setClasses("C0722G1");
        System.out.println(student);
    }
}
