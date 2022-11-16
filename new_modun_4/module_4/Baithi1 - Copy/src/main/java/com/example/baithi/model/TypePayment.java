package com.example.baithi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="type_payment")
public class TypePayment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_payment")
    private int id;
    private String typePayment;

    @OneToMany(mappedBy = "typePayment")
    private List<Motell> motells;

    public TypePayment() {
    }

    public TypePayment(int id, String typePayment, List<Motell> motells) {
        this.id = id;
        this.typePayment = typePayment;
        this.motells = motells;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public List<Motell> getMotells() {
        return motells;
    }

    public void setMotells(List<Motell> motells) {
        this.motells = motells;
    }
}
