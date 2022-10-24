package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface ICustomerService{
    List<Customer> findALL();
    Customer findById(int id);
    void deleteById(int id);
    void saveCustomer(Customer customer);

}
