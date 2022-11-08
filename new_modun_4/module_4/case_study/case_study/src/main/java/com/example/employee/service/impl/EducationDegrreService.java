package com.example.employee.service.impl;


import com.example.employee.model.EducationDegree;
import com.example.employee.repository.IEducationDegreeRepository;
import com.example.employee.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegrreService implements IEducationDegreeService {


    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);

    }

    @Override
    public void delete(int id) {
        educationDegreeRepository.deleteById(id);


    }

    @Override
    public Optional<EducationDegree> findById(int id) {
        return educationDegreeRepository.findById(id);
    }
}
