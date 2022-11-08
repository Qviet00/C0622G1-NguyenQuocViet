package com.example.employee.service;

import com.example.employee.model.Division;

import java.util.List;
import java.util.Optional;

public interface IDivisionService {

    List<Division> findAll();

    void save(Division division);

    void delete(int id);

    Optional<Division> findById (int id);
}
