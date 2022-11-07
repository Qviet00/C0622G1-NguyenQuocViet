package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    void save(Customer customer);

    void delete(int id);

    Optional<Customer> findById (int id);

    Page<Customer> findAllByNameAndAdress(String  name,String email, String type, Pageable pageable);

}
