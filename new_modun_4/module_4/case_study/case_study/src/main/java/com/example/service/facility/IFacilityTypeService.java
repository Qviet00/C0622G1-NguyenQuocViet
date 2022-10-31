package com.example.service.facility;

import com.example.model.facility.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IFacilityTypeService {
   List<FacilityType> findAll();

}
