package com.example.casestudy.contact.model;


import javax.persistence.*;

@Entity
@Table(name="contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;
    private String starDate;
    private String endDate;
    private double deposit;

}
