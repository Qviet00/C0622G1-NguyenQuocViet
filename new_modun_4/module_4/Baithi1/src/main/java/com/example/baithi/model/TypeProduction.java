package com.example.baithi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_production")
public class TypeProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_type_production")
     private int id;
    private String nameTypeProduction;

    @OneToMany(mappedBy = "typeProduction")
    private List<Production> productions;

    public TypeProduction() {
    }

    public TypeProduction(int id, String nameTypeProduction, List<Production> productions) {
        this.id = id;
        this.nameTypeProduction = nameTypeProduction;
        this.productions = productions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeProduction() {
        return nameTypeProduction;
    }

    public void setNameTypeProduction(String nameTypeProduction) {
        this.nameTypeProduction = nameTypeProduction;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }
}
