package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public List<Facility> finAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.save(facility);

    }

    @Override
    public void add(Facility facility) {
        if(facility.getFacilityType().getFacilityTypeId()==1){
            facility.setFacilityFree(null);
        }
        if (facility.getFacilityType().getFacilityTypeId()==2){
            facility.setPoolArea(null);
            facility.setFacilityFree(null);
        }
        if(facility.getFacilityType().getFacilityTypeId()==3){
            facility.setStandardRoom(null);
            facility.setNumberOfFloor(null);
            facility.setPoolArea(null);
            facility.setDescriptionOtherConvenience(null);
        }
        facilityRepository.save(facility);

    }

    @Override
    public Optional<Facility> findId(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAllByFacilityName(String name, Pageable pageable) {
        return facilityRepository.findAllByFacilityName(name, pageable);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }
}
