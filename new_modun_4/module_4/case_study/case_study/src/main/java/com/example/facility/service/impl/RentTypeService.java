package com.example.facility.service.impl;

import com.example.facility.service.IRentTypeService;
import com.example.facility.model.RentType;
import com.example.facility.repository.IRenTypeRepository;
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
