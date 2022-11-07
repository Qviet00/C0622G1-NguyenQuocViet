package com.example.facility.service.impl;

import com.example.facility.service.IFacilityTypeService;
import com.example.facility.model.FacilityType;
import com.example.facility.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
        return facilityTypeRepository.findById(id).orElse(null);
    }
}
