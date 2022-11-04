package com.example.casestudy.facility;


import javax.persistence.*;

@Entity
@Table(name="facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacility;
    private String nameFacility;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    private String facilityFree;
}
