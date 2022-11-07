package com.example.facility.repository;

import com.example.facility.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRenTypeRepository extends JpaRepository<RentType, Integer> {
}
