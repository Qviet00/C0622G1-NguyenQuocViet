package com.example.baithi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "number_production")
public class NumberProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number_production")
    private int id;

    private double number;
    private String starDay;

    @OneToMany(mappedBy = "numberProduction")
    private List<Production> productions;

    public NumberProduction() {
    }

    public NumberProduction(int id, double number, String starDay, List<Production> productions) {
        this.id = id;
        this.number = number;
        this.starDay = starDay;
        this.productions = productions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }
}
