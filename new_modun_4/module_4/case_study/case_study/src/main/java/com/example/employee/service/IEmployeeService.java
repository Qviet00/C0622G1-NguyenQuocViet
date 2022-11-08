package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    void delete(int id);

    Optional<Employee> findById (int id);

    Page<Employee> findAllByPageable(Pageable pageable);

}
