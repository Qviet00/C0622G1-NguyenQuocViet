package com.example.service.facility.impl;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.IFaclityTypeRepository;
import com.example.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFaclityTypeRepository faclityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return faclityTypeRepository.findAll();
    }
}
