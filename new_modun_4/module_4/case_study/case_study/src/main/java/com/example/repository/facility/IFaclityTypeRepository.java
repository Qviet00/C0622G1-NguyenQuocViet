package com.example.repository.facility;

import com.example.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFaclityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
