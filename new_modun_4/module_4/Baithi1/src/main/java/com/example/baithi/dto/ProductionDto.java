package com.example.baithi.dto;

import com.example.baithi.model.NumberProduction;
import com.example.baithi.model.TypeProduction;

public class ProductionDto {
    private int id;
    private String nameProduction;
    private String starday;
    private Double number;

    public String getStarday() {
        return starday;
    }

    public void setStarday(String starday) {
        this.starday = starday;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
    private double poit;
    private int stastus;
    private double summoney;


    private String numberProduction;
    private String typeProduction;

    public ProductionDto() {
    }

    public ProductionDto(int id, String nameProduction, double poit, int stastus, double summoney, String numberProduction, String typeProduction) {
        this.id = id;
        this.nameProduction = nameProduction;
        this.poit = poit;
        this.stastus = stastus;
        this.summoney = summoney;
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

    public int getStastus() {
        return stastus;
    }

    public void setStastus(int stastus) {
        this.stastus = stastus;
    }

    public double getSummoney() {
        return summoney;
    }

    public void setSummoney(double summoney) {
        this.summoney = summoney;
    }

    public String getNumberProduction() {
        return numberProduction;
    }

    public void setNumberProduction(String numberProduction) {
        this.numberProduction = numberProduction;
    }

    public String getTypeProduction() {
        return typeProduction;
    }

    public void setTypeProduction(String typeProduction) {
        this.typeProduction = typeProduction;
    }
}
