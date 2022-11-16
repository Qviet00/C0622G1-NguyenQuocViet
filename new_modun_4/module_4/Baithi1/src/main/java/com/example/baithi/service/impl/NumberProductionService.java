package com.example.baithi.service.impl;

import com.example.baithi.model.NumberProduction;
import com.example.baithi.repository.NumberProductionRepository;
import com.example.baithi.service.INumberProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NumberProductionService implements INumberProductionService {

    @Autowired
    NumberProductionRepository numberProductionRepository;
    @Override
    public List<NumberProduction> findAll() {
        return numberProductionRepository.findAll();
    }
}
