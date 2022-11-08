package com.example.employee.service;

import com.example.employee.model.EducationDegree;

import java.util.List;
import java.util.Optional;

public interface IEducationDegreeService {

    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    void delete(int id);

    Optional<EducationDegree> findById (int id);
}
