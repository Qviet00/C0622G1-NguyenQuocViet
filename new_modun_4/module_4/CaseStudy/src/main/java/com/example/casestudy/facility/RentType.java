package com.example.casestudy.facility;


import javax.persistence.*;

@Entity
@Table(name="renttType")
public class RentType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRentType;
    private String name;
}
