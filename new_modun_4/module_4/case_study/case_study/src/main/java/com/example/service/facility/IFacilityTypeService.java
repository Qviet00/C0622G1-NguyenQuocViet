package com.example.service.facility;

import com.example.model.customer.TypeCustomer;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
    FacilityType findById(int id);
}
