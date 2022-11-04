package com.example.repository.customer;

import com.example.model.customer.TypeCustomer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeCustomerRepository extends JpaRepository<TypeCustomer, Integer> {
}
