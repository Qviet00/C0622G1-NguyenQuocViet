package com.example.casestudy.facility;


import javax.persistence.*;

@Entity
@Table(name="faceilityType")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacilityType;
    private String nameFacilityType;

}
