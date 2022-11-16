package com.example.baithi.model;


import javax.persistence.*;

@Entity
@Table(name = "motell")
public class Motell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motel")
    private int id;
    private String name;
    private String phone;
    private String starDay;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_payment", referencedColumnName = "id_type_payment")
    private TypePayment typePayment;

    public Motell() {
    }

    public Motell(int id, String name, String phone, String starDay, TypePayment typePayment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.starDay = starDay;
        this.typePayment = typePayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public TypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }
}

