package com.example.demo.modell;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "smartphones")
public class Smartphone {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String producer;
    private String model;
    private double price;

    public Smartphone() {
    }

}
