package com.example.service.customer.impl;

import com.example.model.customer.TypeCustomer;
import com.example.repository.customer.ITypeCustomerRepository;
import com.example.service.customer.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerService implements ITypeCustomerService {
    @Autowired
    private ITypeCustomerRepository iTypeCustomerRepository;
    @Override
    public List<TypeCustomer> findAll() {
        return iTypeCustomerRepository.findAll();
    }

    @Override
    public TypeCustomer findById(int id) {
        return iTypeCustomerRepository.findById(id).orElse(null);
    }

}
