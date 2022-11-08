package com.example.employee.service.impl;

import com.example.employee.model.Division;
import com.example.employee.repository.IDivisionRepository;
import com.example.employee.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(int id) {
        divisionRepository.deleteById(id);

    }

    @Override
    public Optional<Division> findById(int id) {
        return divisionRepository.findById(id);
    }
}
