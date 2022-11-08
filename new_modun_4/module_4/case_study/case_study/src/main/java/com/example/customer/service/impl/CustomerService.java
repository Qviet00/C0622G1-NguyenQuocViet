package com.example.customer.service.impl;

import com.example.customer.model.Customer;
import com.example.customer.repository.ICustomerRepository;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllByNameAndAdress(String name, String email, String type, Pageable pageable) {
        return iCustomerRepository.findAllByNameAndAdress(name,email,type,pageable);
    }

}
