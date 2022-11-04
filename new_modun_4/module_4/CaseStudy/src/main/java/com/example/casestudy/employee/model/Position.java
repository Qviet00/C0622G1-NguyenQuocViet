package com.example.casestudy.employee.model;

import javax.persistence.*;

@Entity
@Table(name ="position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosition;
    private String namePosition;
}
