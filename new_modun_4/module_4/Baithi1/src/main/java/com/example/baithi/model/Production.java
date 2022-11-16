package com.example.baithi.model;

import javax.persistence.*;

@Entity
@Table(name = "production")

public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_production")
    private int id;
    private String nameProduction;
    private double poit;
    private int stastus;

    public int getStastus() {
        return stastus;
    }

    public void setStastus(int stastus) {
        this.stastus = stastus;
    }

    @ManyToOne
    @JoinColumn(name="id_number_production", referencedColumnName = "id_number_production")
    private NumberProduction numberProduction;
    @ManyToOne
    @JoinColumn(name = "id_type_production", referencedColumnName = "id_type_production")
    private TypeProduction typeProduction;

    public Production() {
    }

    public Production(int id, String nameProduction, double poit, NumberProduction numberProduction, TypeProduction typeProduction) {
        this.id = id;
        this.nameProduction = nameProduction;
        this.poit = poit;
        this.numberProduction = numberProduction;
        this.typeProduction = typeProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduction() {
        return nameProduction;
    }

    public void setNameProduction(String nameProduction) {
        this.nameProduction = nameProduction;
    }

    public double getPoit() {
        return poit;
    }

    public void setPoit(double poit) {
        this.poit = poit;
    }


    public NumberProduction getNumberProduction() {
        return numberProduction;
    }

    public void setNumberProduction(NumberProduction numberProduction) {
        this.numberProduction = numberProduction;
    }

    public TypeProduction getTypeProduction() {
        return typeProduction;
    }

    public void setTypeProduction(TypeProduction typeProduction) {
        this.typeProduction = typeProduction;
    }
}
