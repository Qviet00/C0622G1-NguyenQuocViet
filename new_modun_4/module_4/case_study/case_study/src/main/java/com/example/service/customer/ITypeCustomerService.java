package com.example.service.customer;

import com.example.model.customer.TypeCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeCustomerService {
    List<TypeCustomer> findAll();
    TypeCustomer findById(int id);
}
