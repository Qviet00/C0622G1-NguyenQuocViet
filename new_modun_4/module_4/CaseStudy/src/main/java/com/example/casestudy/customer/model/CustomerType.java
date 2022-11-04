package com.example.casestudy.customer.model;


import javax.persistence.*;

@Entity
@Table(name="customerType")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomerType;
    private String nameCustomerType;
}
