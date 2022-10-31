package com.example.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Class itClass;

    public Student() {
    }

    public Student(int id, String name, int age, Class itClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.itClass = itClass;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Class getItClass() {
        return itClass;
    }

    public void setItClass(Class itClass) {
        this.itClass = itClass;
    }
}
