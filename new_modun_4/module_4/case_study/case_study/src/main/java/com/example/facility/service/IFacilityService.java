package com.example.facility.service;

import com.example.facility.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    void add(Facility facility);
    void save(Facility facility);

    void delete(int id);

    Optional<Facility> findById (int id);

    Page<Facility> findAllFacility(String  name, String facilityType, Pageable pageable);

}
