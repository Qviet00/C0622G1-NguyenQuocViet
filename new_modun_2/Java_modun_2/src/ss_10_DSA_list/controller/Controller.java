package ss_10_DSA_list.controller;

import ss_10_DSA_list.model.MyArrayList;

public class Controller {
    public static class Student {
        private final int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Nam");
        Student student2 = new Student(2, "Uyên");
        Student student3 = new Student(3, "Hãi");
        Student student4 = new Student(4, "Duy");
        Student student5 = new Student(5, "Sáng");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(student5);
        for (int i=0;i<studentMyArrayList.size();i++){
            Student student= (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
    }
}
