package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    void save(Customer customer);

    void delete(int id);

    Optional<Customer> findById (int id);

    Page<Customer> findAllByCustomer(Pageable pageable);
    Page<Customer> findAllByNameAndAdress(String  name,String email, String type, Pageable pageable);

}
