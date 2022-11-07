package com.example.facility.service.impl;

import com.example.facility.service.IFacilityService;
import com.example.facility.model.Facility;
import com.example.facility.repository.IFacilityRepository;
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
    public void add(Facility facility) {
        if (facility.getFacilityType().getFacilityTypeId()==1){
            facility.setFacilityFree(null);
        }
        if (facility.getFacilityType().getFacilityTypeId()==2){
            facility.setPoolArea(null);
            facility.setFacilityFree(null);
        }
        if (facility.getFacilityType().getFacilityTypeId()==3){
            facility.setStandardRoom(null);
            facility.setNumberOfFloor(null);
            facility.setPoolArea(null);
            facility.setDescriptionOtherConvenience(null);
        }
        facilityRepository.save(facility);
    }

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
    public Page<Facility> findAllFacility(String name, String facelityType, Pageable pageable) {
        return facilityRepository.findAllFacility(name,facelityType,pageable);
    }
}
