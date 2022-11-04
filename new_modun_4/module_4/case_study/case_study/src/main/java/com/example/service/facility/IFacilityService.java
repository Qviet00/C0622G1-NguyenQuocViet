package com.example.service.facility;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    void save(Facility facility);

    void delete(int id);

    Optional<Facility> findById (int id);

    Page<Facility> findAllByFacility(Pageable pageable);
    Page<Facility> findAllByNameAndAdress(String  name, String facilityType, Pageable pageable);

}
