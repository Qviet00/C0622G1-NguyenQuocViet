package com.example.casestudy.employee.model;


import javax.persistence.*;

@Entity
@Table(name = "divsion")
public class Division {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDivision;
    private String nameDivision;
}
