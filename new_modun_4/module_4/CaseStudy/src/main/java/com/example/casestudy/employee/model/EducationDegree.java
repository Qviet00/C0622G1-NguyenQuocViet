package com.example.casestudy.employee.model;


import javax.persistence.*;

@Entity
@Table(name="educationDegree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducationDegree;
    private String nameDucationDegree;
}
