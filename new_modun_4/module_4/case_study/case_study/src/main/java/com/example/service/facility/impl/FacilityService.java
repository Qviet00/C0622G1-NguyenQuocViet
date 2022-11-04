package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);

    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);

    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAllByFacility(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Page<Facility> findAllByNameAndAdress(String name, String facelityType, Pageable pageable) {
        return findAllByNameAndAdress(name,facelityType,pageable);
    }
}
