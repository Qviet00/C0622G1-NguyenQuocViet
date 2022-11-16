package com.example.baithi.service.impl;

import com.example.baithi.model.TypeProduction;
import com.example.baithi.repository.TypeProductionRepository;
import com.example.baithi.service.ITypeProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeProductionService implements ITypeProductionService {

    @Autowired
    TypeProductionRepository typeProductionRepository;
    @Override
    public List<TypeProduction> findAll() {
        return typeProductionRepository.findAll();
    }
}
