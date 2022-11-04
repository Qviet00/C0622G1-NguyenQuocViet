package com.example.casestudy.customer.model;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    private String nameCustomer;
    private String dataOfBirth;
    private String gender;
    private String idCard;
    private String phoneNumer;
    private String email;
    private String address;
}
