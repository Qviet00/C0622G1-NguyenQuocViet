package com.example.service.facility.impl;

import com.example.model.facility.RentType;
import com.example.repository.facility.IRenTypeRepository;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRenTypeRepository renTypeRepository;
    @Override
    public List<RentType> findAll() {
        return renTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return renTypeRepository.findById(id).orElse(null);
    }
}
